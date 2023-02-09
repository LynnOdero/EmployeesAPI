package com.lynn.employees.service;

import com.lynn.employees.entities.Employee;
import com.lynn.employees.requests.UpdateEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.lynn.employees.repositories.EmployeeRepository;
import com.lynn.employees.requests.EmployeeInfo;
import com.lynn.employees.responses.EmployeeResponse;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    final EmployeeRepository employeeRepository;

    public EmployeeResponse createEmployee(EmployeeInfo info){
        Employee employee = Employee.builder()
                .address(info.getAddress())
                .position(info.getTitle())
                .name(info.getName())
                .build();
        employeeRepository.save(employee);

                return EmployeeResponse
                        .builder()
                        .staffNumber(employee.getStaffNumber())
                        .message("employee created succesfully")
                        .status(true)
                        .build();
    }
    public EmployeeInfo getEmployeeByStaffNumber(int staffNumber){
      Optional<Employee> optionalEmployee = employeeRepository.findById(staffNumber);
      if (optionalEmployee.isEmpty()){
          return null;
      }
      Employee employee = optionalEmployee.get();
      EmployeeInfo employeeInfo = EmployeeInfo.builder()
        .staffNumber(employee.getStaffNumber())
              .name(employee.getName())
              .address(employee.getAddress())
              .title(employee.getPosition())
              .build();

      return employeeInfo;
    }

    public EmployeeResponse updateEmployee(UpdateEmployee info) {
        Optional<Employee> employeeOptional = employeeRepository.findById(info.staffNumber);
        if (employeeOptional.isEmpty()) {
            return null;
        }
        Employee employee = employeeOptional.get();
        employee.setAddress(info.address);
        employee.setPosition(info.title);
        employee.setName(info.name);
        employeeRepository.save(employee);
        return EmployeeResponse.builder()
                .message("Employee update successfully")
                .staffNumber(employee.getStaffNumber())
                .status(true)
                .build();
    }

    public EmployeeResponse deleteEmployee(int staffNumber){
        try {
            employeeRepository.deleteById(staffNumber);
            return EmployeeResponse
                    .builder()
                    .staffNumber(staffNumber)
                    .message("employee deleted succesfully")
                    .status(true)
                    .build();
        } catch (EmptyResultDataAccessException e) {
            return EmployeeResponse
                    .builder()
                    .staffNumber(staffNumber)
                    .message("An error occurred while deleting employee")
                    .status(false)
                    .build();
        }
    }



}
