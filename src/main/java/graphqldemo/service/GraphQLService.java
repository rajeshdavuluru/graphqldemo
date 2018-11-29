package graphqldemo.service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
@Slf4j
public class GraphQLService {
    @Autowired
    private ResourceLoader resourceLoader;

    private GraphQL graphQL;

    @Autowired
    private EmploeeDetailsDataFetcher emploeeDetailsDataFetcher;

    @PostConstruct
    private void loadSchema() throws IOException {

        log.debug("111111111111111111111111111111111111111");
        Resource resource = resourceLoader.getResource("classpath:employeeDetails.graphqls");
        log.debug("resource:--" + resource);

        InputStream stream = resource.getInputStream();
        log.debug("stream:--" + stream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        log.debug("reader:--" + reader);

        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(reader);
        log.debug("typeRegistry:--" + typeRegistry);
        RuntimeWiring wiring = buildRuntimeWiring();
        log.debug("wiring:--" + wiring);
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        log.debug("schema:--" + schema);
        graphQL = GraphQL.newGraphQL(schema).build();
        log.debug("graphQL11111:--" + graphQL);

    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("employeeDetails", emploeeDetailsDataFetcher)
                )
                .build();
    }


    public GraphQL getGraphQL() {
        log.debug("graphQL:--" + graphQL);
        return graphQL;
    }
}
