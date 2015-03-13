package com.itechart.library.core.book.service;

import com.itechart.library.core.book.Book;
import com.itechart.library.core.book.DownloadedBook;
import com.itechart.library.core.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface BookService {

    Book find(Long id);

    Iterable<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    Page<DownloadedBook> findDownloadedBooks(long userId, Pageable pageable);
    Page<User> findUsersDownloadingBook(long bookId, Pageable pageable);

    DownloadedBook downloadBook(long userId, long bookId);
}
