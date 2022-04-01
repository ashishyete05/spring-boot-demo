package com.example.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "emp_seq_generator")
    @SequenceGenerator(name = "emp_seq_generator",sequenceName = "emp_seq", allocationSize = 1)
    private Integer empID;
    private String empName;
    private String empDesignation;
    private String empOfficeLocation;

}
