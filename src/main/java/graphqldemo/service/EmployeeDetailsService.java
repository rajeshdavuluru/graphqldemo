package graphqldemo.service;

import graphqldemo.client.EmployeeDetailsClient;
import graphqldemo.domain.EmployeeDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@FunctionalInterface
public interface EmployeeDetailsService<T, U> {
    U employeeDetails1(T empId);

    @Component
    @RequiredArgsConstructor
    class Default implements EmployeeDetailsService<String, EmployeeDetails>{
        private final EmployeeDetailsClient employeeDetailsClient;

        @Override
        public EmployeeDetails employeeDetails1(String empId) {
            return employeeDetailsClient.employeeDetails(empId);
        }
    }
}
