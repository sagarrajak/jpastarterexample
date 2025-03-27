package com.jpastarterexample.in21mincourse.jpastarterexample;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperconcrete.Subjects;
import com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperconcrete.Teacher;
import com.jpastarterexample.in21mincourse.jpastarterexample.repository.TeacherRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceUnitUtil;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class TestRepositoryCommandLine implements CommandLineRunner {
    private final TeacherRepository teacherRepository;
    private final EntityManager em;

    public PersistenceUnitUtil getPersistenceUnitUtil() {
        return em.getEntityManagerFactory().getPersistenceUnitUtil();
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public void run(String... args) throws Exception {
//        List<Teacher> mathematics = teacherRepository.findTeacherBySubjects("Mathematics");
//        mathematics.forEach(System.out::println);
//        Teacher teacher = em.find(Teacher.class, 1L);
//        Teacher reference = em.getReference(Teacher.class, 2L);
//        boolean loaded = getPersistenceUnitUtil().isLoaded(teacher);
//        System.out.println("Loaded: " + loaded);
//        teacher.setFirstName("Something2");
////        em.persist(teacher);/
//        List<Teacher> resultList = em.createQuery("select t from teacher t where t.firstName = :id", Teacher.class)
//                .setParameter("id", "Something")
//                .getResultList();
//            resultList.forEach(System.out::println);
//        this.makingDataTransient();
        this.testLazyLoading();
    }


    @Transactional
    public void makingDataTransient() {
        Teacher teacher = em.find(Teacher.class, 2L);
        String fullName = teacher.getFullName();
        em.remove(teacher);
        em.contains(teacher);
        System.out.println(fullName);
    }

    public void testLazyLoading() {
        Subjects subjects = em.find(Subjects.class, 1L);
        boolean loaded = this.getPersistenceUnitUtil().isLoaded(subjects, "teacherList");
        System.out.println("isLoaded teachers: " + loaded);
//        Hibernate.initialize(subjects.getTeacherList()); // First way to init
//        subjects.getTeacherList().iterator(); // Second way to init
        boolean loadedAfter = this.getPersistenceUnitUtil().isLoaded(subjects, "teacherList");
        System.out.println("isLoaded teachers: " + loadedAfter);
        
    }



}
