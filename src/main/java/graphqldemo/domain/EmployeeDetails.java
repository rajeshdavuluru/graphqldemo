package graphqldemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {
    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeePhone;
    private String employeeEmail;

}
