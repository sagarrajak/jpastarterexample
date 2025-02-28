package com.jpastarterexample.in21mincourse.jpastarterexample.entity;

import com.jpastarterexample.in21mincourse.jpastarterexample.Address;
import com.jpastarterexample.in21mincourse.jpastarterexample.sequenceGenerater.EmployeeId;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Formula;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class Employee {
        @Id
        @EmployeeId
        private String id; // Primary key will be "EMP-1", "EMP-2", etc.

        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name", nullable = false)
        private String lastName;

        private Double salery;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "manager_id")
        private Employee manager;

        @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
        private List<Employee> subordinates;

        @Formula("concat(first_name, ' ', last_name)")
        private String fullName;

        @Enumerated(EnumType.STRING)
        private String employeeType;


        @AttributeOverrides({
                @AttributeOverride(name = "street1", column = @Column(name = "billing_street1")),
                @AttributeOverride(name = "street2", column = @Column(name = "billing_street2")),
                @AttributeOverride(name = "city", column = @Column(name = "billling_city")),
                @AttributeOverride(name = "zipcode", column = @Column(name = "billing_zipcode")),
        })
        private Address billingAddress;


        @AttributeOverrides({
                @AttributeOverride(name = "street1", column = @Column(name = "billing_street1")),
                @AttributeOverride(name = "street2", column = @Column(name = "billing_street2")),
                @AttributeOverride(name = "city", column = @Column(name = "billling_city")),
                @AttributeOverride(name = "zipcode", column = @Column(name = "billing_zipcode")),
        })
        private Address shippingAddress;
}
