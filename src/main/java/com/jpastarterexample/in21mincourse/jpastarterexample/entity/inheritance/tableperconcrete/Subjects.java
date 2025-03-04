package com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperconcrete;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "subjects")
    private List<Teacher> teacherList;
}
