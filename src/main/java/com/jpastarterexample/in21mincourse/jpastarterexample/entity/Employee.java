package com.jpastarterexample.in21mincourse.jpastarterexample.entity;

import com.jpastarterexample.in21mincourse.jpastarterexample.sequenceGenerater.EmployeeId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Employee {
        @Id
        @EmployeeId
        private String id; // Primary key will be "EMP-1", "EMP-2", etc.

        private String name;

        private Double salery;
}
