package com.lynn.employees.controllers;

import com.lynn.employees.requests.UpdateEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lynn.employees.requests.EmployeeInfo;
import com.lynn.employees.responses.EmployeeResponse;
import com.lynn.employees.service.EmployeeService;

@RestController
@RequiredArgsConstructor
public class EmployeeControler {

   final EmployeeService service;
    @PostMapping("employee/create")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeInfo info){
       EmployeeResponse response = service.createEmployee(info);
       return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("employee/get")
    public ResponseEntity<EmployeeInfo> getEmployee(@RequestParam(name = "staffNumber")int staffNumber){
        EmployeeInfo info =  service.getEmployeeByStaffNumber(staffNumber);
        if (info == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @PutMapping("employee/update")
    public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody UpdateEmployee employee) {
        EmployeeResponse response =  service.updateEmployee(employee);
        if (response == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("employee/delete")
    public ResponseEntity<EmployeeResponse> deleteEmployee(@RequestParam ("staffNumber") int staffNo){
        EmployeeResponse info = service.deleteEmployee(staffNo);
        if (!info.status) {
            return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
}
