package com.lynn.employees.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    public Employee(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffNumber;
    public String name;
    public String address;
    public String position;

}
