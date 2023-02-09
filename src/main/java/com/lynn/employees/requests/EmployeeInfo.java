package com.lynn.employees.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EmployeeInfo {
    public String name;
    public String address;
    public String title;
    public Integer staffNumber;
}
