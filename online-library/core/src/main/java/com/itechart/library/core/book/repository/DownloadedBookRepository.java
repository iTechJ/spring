package com.itechart.library.core.book.repository;

import com.itechart.library.core.book.DownloadedBook;
import com.itechart.library.core.entity.repository.EntityRepository;
import com.itechart.library.core.user.User;
import com.mysema.query.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadedBookRepository extends EntityRepository<DownloadedBook>, DownloadedBookRepositoryCustom {

}
