package com.lynn.employees.responses;

import lombok.Builder;

@Builder
public class EmployeeResponse {
    public String message;
    public boolean status;
    public Integer staffNumber;
}
