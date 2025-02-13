package com.jpastarterexample.in21mincourse.jpastarterexample.sequenceGenerater;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;

import java.time.OffsetDateTime;
import java.util.EnumSet;

public class EmployeeIdGenerater implements BeforeExecutionGenerator {
    private final CounterService counterService;

    public EmployeeIdGenerater(CounterService counterService) {
        this.counterService = counterService;
    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object owner, Object currentValue, EventType eventType) {
        return "EMP-"+counterService.nextInteger(session);

    }

    @Override
    public EnumSet<EventType> getEventTypes() {
        return EnumSet.of(EventType.INSERT);
    }

    interface CounterService {
        Long nextInteger(SharedSessionContractImplementor session);
    }
}
