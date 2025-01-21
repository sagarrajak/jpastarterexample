package com.jpastarterexample.in21mincourse.jpastarterexample;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
class CourseRepositoryTest {
    @Autowired
    private TestEntityManager em;

    @Test
    void testPlayWithJpa() {
        Course course = new Course();
        course.setName("test");
        course.setDescription("Java Persistence Eclipse");
        em.persist(course);
        course.setName("Hibernate");
        Course foundCourse = em.find(Course.class, course.getId());
        assertEquals(course, foundCourse);
        assertEquals(course.getName(), foundCourse.getName());
        System.out.println(foundCourse.getName());
    }

    @Test
    @DisplayName("Test entity manager flush and detach")
    void testEntityManagerFlushAndDetach() {
        Course course = new Course();
        course.setDescription("Java Persistence Eclipse");
        course.setName("test1");
        em.persist(course);
        em.detach(course);
        course.setName("test_new");
        em.flush();
        assertNotEquals(course.getName(), em.find(Course.class, course.getId()).getName());

        Course newCourse = new Course();
        newCourse.setName("test2");
        newCourse.setDescription("Java Persistence Eclipse");
        em.persist(newCourse);
        em.clear();
        newCourse.setName("test2_changes");
        assertNotEquals(newCourse.getName(), em.find(Course.class, newCourse.getId()).getName());
    }


    @Test
    @DisplayName("Refresh method entity manager test")
    void testRefresh() {
        Course course = new Course();
        course.setDescription("Java Persistence Eclipse");
        course.setName("test");
        em.persist(course);
        course.setName("test_new");
        em.flush();
        em.refresh(course);
        assertEquals(course.getName(), em.find(Course.class, course.getId()).getName());
    }


}

