package com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperconcrete;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity(name = "teacher")
@Data
@ToString(callSuper = true)
public class Teacher extends Person{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subjects subjects;
}
