package com.jpastarterexample.in21mincourse.jpastarterexample.repository;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperconcrete.Teacher;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    @Query("SELECT t FROM teacher t join   t.subjects s WHERE s.name = :subjectName")
    List<Teacher> findTeacherBySubjects(@Param("subjectName") String subjectName);
}
