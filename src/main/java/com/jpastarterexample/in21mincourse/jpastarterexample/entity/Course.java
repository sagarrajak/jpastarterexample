package com.jpastarterexample.in21mincourse.jpastarterexample.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "course")
@Data
@Entity
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "findAllCourses",
                query = "select i from Course i order by i.createdDate"
        )
})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;

    @org.hibernate.annotations.CreationTimestamp
    LocalDateTime createdDate;

    @org.hibernate.annotations.UpdateTimestamp
    LocalDateTime updatedDate;
}
