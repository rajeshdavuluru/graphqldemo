package graphqldemo.controller;

import graphql.ExecutionResult;
import graphqldemo.domain.EmployeeDetails;
import graphqldemo.service.EmployeeDetailsService;
import graphqldemo.service.GraphQLService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/graphqldemo/v1")
@RequiredArgsConstructor
@Slf4j
public class GraphqlDemoController {

    private final EmployeeDetailsService<String, EmployeeDetails> employeeDetailsService;

    @Autowired
    GraphQLService graphQLService;

    /**
     * below method with graphql
     * @param query
     * @param empId
     * @return
     */
    @GetMapping(value = "/{empId}/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> employeeDetails(@RequestParam("query") String query,
                                                  @PathVariable(name = "empId") String empId) {
        log.info("GraphqlDemoController - employeeDetails() - Start");
        ExecutionResult execute = graphQLService.getGraphQL().execute(query);
        log.info("GraphqlDemoController - employeeDetails() - End");
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

    /**
     * Below method is for without graphql
     * @param empId
     * @return
     */
    @GetMapping(value = "/{empId}/details1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDetails> employeeDetails1(@PathVariable(name = "empId") String empId) {
        log.info("GraphqlDemoController - employeeDetails1() - Start");
        EmployeeDetails employeeDetails = employeeDetailsService.employeeDetails1(empId);
        log.info("GraphqlDemoController - employeeDetails1() - End");
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }

}
