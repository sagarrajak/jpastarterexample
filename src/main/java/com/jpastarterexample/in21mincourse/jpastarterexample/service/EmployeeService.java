package com.jpastarterexample.in21mincourse.jpastarterexample.service;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EntityManager em;

    public EmployeeService(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void saveDummyEmployees() {
        for (int i = 1; i <= 10; i++) {
            Employee employee = new Employee();
            employee.setName("Employee " + i);
            employee.setSalery(1000.0 * i); // Adjust the salary as needed
            em.persist(employee);
        }
    }
}
