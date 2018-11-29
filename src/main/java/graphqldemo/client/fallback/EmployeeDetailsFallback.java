package graphqldemo.client.fallback;

import graphqldemo.client.EmployeeDetailsClient;
import graphqldemo.domain.EmployeeDetails;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDetailsFallback implements EmployeeDetailsClient {
    @Override
    public EmployeeDetails employeeDetails(String guid) {
        return EmployeeDetails.builder()
                .employeeId("1001")
                .employeeFirstName("Rajesh")
                .employeeLastName("Davuluru")
                .employeePhone("9999999999")
                .employeeEmail("test@gmail.com")
                .build();
    }
}
