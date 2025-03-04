package com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperconcrete;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "teacher")
@Data
public class Teacher extends Person{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subjects subjects;
}
