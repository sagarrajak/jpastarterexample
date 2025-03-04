package com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperconcrete;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = "teacherList")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "subjects", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Teacher> teacherList = new ArrayList<>();
}
