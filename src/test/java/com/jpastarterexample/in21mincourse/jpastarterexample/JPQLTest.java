package com.jpastarterexample.in21mincourse.jpastarterexample;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.logging.Logger;

@DataJpaTest
public class JPQLTest {
    private static final Logger log = Logger.getLogger(JPQLTest.class.getName());

    @Autowired
    private EntityManager em;

    @BeforeEach
    void setUp() {
        Course course = new Course();
        course.setName("test");
        course.setDescription("Description");
        em.persist(course);

        Course course2 = new Course();
        course.setName("test2");
        course.setDescription("Description2");
        em.persist(course2);
    }

    @DisplayName("JPQL test save method")
    @Test
    public void testSave() {
        TypedQuery<Course> selectCFromCourseC = em.createQuery("select c from Course c", Course.class);
        List<Course> courses = selectCFromCourseC.getResultList();
        log.info("Size of courses: " + courses.size());
        courses.get(0).setName("test");
        em.merge(courses.get(0));
        log.info("First course: " + courses.get(0));
    }

    @DisplayName("find all coursed using named query")
    @Test
    public void testFindAll() {
        TypedQuery<Course> findAllCourses = em.createNamedQuery("findAllCourses", Course.class);
    }
}
