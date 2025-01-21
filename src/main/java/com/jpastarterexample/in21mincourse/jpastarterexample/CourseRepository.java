package com.jpastarterexample.in21mincourse.jpastarterexample;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Slf4j
@Component
public class CourseRepository {
    private final EntityManager em;

    public CourseRepository(EntityManager em) {
        this.em = em;
    }

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    @Transactional
    public Course playWithEntityManager(String name) {
        Course course = new Course();
        course.setName(name);
        course.setDescription("Java Persistence Eclipse");
        em.persist(course);
        course.setName("Hibernate");
        return course;
    }


    public void testFindAll() {
        TypedQuery<Course> findAllCourses = em.createNamedQuery("findAllCourses", Course.class);
    }
}
