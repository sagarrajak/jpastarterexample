package com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperconcrete;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("STUDENT")
public class Student extends Person {
    private String major;
    private String course;
}
