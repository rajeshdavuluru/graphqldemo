package graphqldemo.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphqldemo.client.EmployeeDetailsClient;
import graphqldemo.domain.EmployeeDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueryResolver implements GraphQLQueryResolver {
    @Autowired
    private EmployeeDetailsClient employeeDetailsClient;


    public EmployeeDetails employeeDetails() {
        log.info("QueryResolver - employeeDetails() - Start");
        EmployeeDetails response = employeeDetailsClient.employeeDetails("");
        log.info("QueryResolver - employeeDetails() - Start");
        return response;
    }

}
