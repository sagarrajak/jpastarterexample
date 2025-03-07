package com.jpastarterexample.in21mincourse.jpastarterexample.repository;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.products.Bids;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidsRepository extends JpaRepository<Bids, Long> {
}
