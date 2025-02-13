package com.jpastarterexample.in21mincourse.jpastarterexample.sequenceGenerater;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersistenceCounterService implements EmployeeIdGenerater.CounterService {
    @Override
    public Long nextInteger(SharedSessionContractImplementor session) {
        var statelessSession = session.isStatelessSession() ? session.asStatelessSession() : session.getSession();
        List<?> result = statelessSession.createNativeQuery(
                        "SELECT next_val FROM employee_sequence WHERE sequence_name = :seqName FOR UPDATE")
                .setParameter("seqName", "employee_sequence")
                .getResultList();

        if (result.isEmpty()) {
            statelessSession.createNativeMutationQuery(
                            "INSERT INTO employee_sequence(sequence_name, next_val) VALUES (:seqName, :nextVal)")
                    .setParameter("seqName", "employee_sequence")
                    .setParameter("nextVal", 2L)
                    .executeUpdate();
            return 1L;
        } else {
            long currentVal = ((Number) result.get(0)).longValue();
            statelessSession.createNativeMutationQuery(
                            "UPDATE employee_sequence SET next_val = next_val + 1 WHERE sequence_name = :seqName")
                    .setParameter("seqName", "employee_sequence")
                    .executeUpdate();
            return currentVal;
        }
    }
}
