package graphqldemo.client;

import feign.Headers;
import graphqldemo.client.fallback.EmployeeDetailsFallback;
import graphqldemo.domain.EmployeeDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${employeeDetails.api.name}", url = "${employeeDetails.api.url}", fallback = EmployeeDetailsFallback.class)
public interface EmployeeDetailsClient {

    @GetMapping(value = "/{empId}/details",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Headers({"Content-Type: " + MediaType.APPLICATION_JSON_VALUE})
    EmployeeDetails employeeDetails(@PathVariable("empId") String empId);
}
