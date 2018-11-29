package graphqldemo.service;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphqldemo.client.EmployeeDetailsClient;
import graphqldemo.domain.EmployeeDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmploeeDetailsDataFetcher implements DataFetcher<EmployeeDetails> {

    @Autowired
    private EmployeeDetailsClient employeeDetailsClient;

    @Override
    public EmployeeDetails get(DataFetchingEnvironment dataFetchingEnvironment) {
        EmployeeDetails res = employeeDetailsClient.employeeDetails("");
        return res;
    }
}
