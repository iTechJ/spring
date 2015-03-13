package com.itechart.library.core.book.repository;

import com.itechart.library.core.book.DownloadedBook;
import com.itechart.library.core.book.QDownloadedBook;
import com.itechart.library.core.user.User;
import com.mysema.query.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.Collections;
import java.util.List;

public class DownloadedBookRepositoryCustomImpl extends QueryDslRepositorySupport implements DownloadedBookRepositoryCustom {
    private static final QDownloadedBook QD_BOOK = QDownloadedBook.downloadedBook;

    public DownloadedBookRepositoryCustomImpl() {
        super(DownloadedBook.class);
    }

    @Override
    public Page<DownloadedBook> findByUserId(long userId, Pageable pageable) {
        JPQLQuery countQuery = queryByUserId(userId);
        JPQLQuery query = getQuerydsl().applyPagination(pageable, queryByUserId(userId));

        Long total = countQuery.count();
        List<DownloadedBook> content = total > pageable.getOffset() ? query.list(QD_BOOK) : Collections.<DownloadedBook>emptyList();

        return new PageImpl(content, pageable, total);
    }

    private JPQLQuery queryByUserId(long userId) {
        return from(QD_BOOK).innerJoin(QD_BOOK.book).fetch().innerJoin(QD_BOOK.user).fetch().where(QD_BOOK.user.id.eq(userId));
    }

    @Override
    public Page<User> findUsersDownloadingBook(long bookId, Pageable pageable) {
        JPQLQuery countQuery = from(QD_BOOK).where(QD_BOOK.book.id.eq(bookId));
        JPQLQuery query = from(QD_BOOK).where(QD_BOOK.book.id.eq(bookId));
        query = getQuerydsl().applyPagination(pageable, query);

        Long total = countQuery.count();
        List<User> content = total > pageable.getOffset() ? query.list(QD_BOOK.user) : Collections.<User>emptyList();

        return new PageImpl(content, pageable, total);
    }


}
