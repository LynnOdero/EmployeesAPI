package com.lynn.employees.requests;

import lombok.Builder;

@Builder
public class UpdateEmployee {
    public String name;
    public String address;
    public String title;
    public Integer staffNumber;
}
