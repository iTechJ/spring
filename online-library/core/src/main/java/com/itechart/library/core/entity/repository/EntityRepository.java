package com.itechart.library.core.entity.repository;

import com.itechart.library.core.entity.Entity;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


@NoRepositoryBean
public interface EntityRepository<T extends Entity> extends PagingAndSortingRepository<T, Long>, QueryDslPredicateExecutor<T> {

}
