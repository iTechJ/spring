package com.itechart.library.core.book.repository;

import com.itechart.library.core.book.Book;
import com.itechart.library.core.entity.repository.EntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends EntityRepository<Book> {
}
