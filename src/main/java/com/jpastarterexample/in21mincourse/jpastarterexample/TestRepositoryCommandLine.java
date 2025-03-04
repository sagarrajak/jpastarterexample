package com.jpastarterexample.in21mincourse.jpastarterexample;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperconcrete.Teacher;
import com.jpastarterexample.in21mincourse.jpastarterexample.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TestRepositoryCommandLine implements CommandLineRunner {
    private final TeacherRepository teacherRepository;

    public TestRepositoryCommandLine(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Teacher> mathematics = teacherRepository.findTeacherBySubjects("Mathematics");
        mathematics.forEach(System.out::println);
    }
}
