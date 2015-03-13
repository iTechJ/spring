package com.itechart.library.core.book.service;

import com.itechart.library.core.book.Book;
import com.itechart.library.core.book.DownloadedBook;
import com.itechart.library.core.book.repository.BookRepository;
import com.itechart.library.core.book.repository.DownloadedBookRepository;
import com.itechart.library.core.entity.service.AbstractEntityService;
import com.itechart.library.core.user.User;
import com.itechart.library.core.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookServiceImpl extends AbstractEntityService<Book> implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private DownloadedBookRepository dlBookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<DownloadedBook> findDownloadedBooks(long userId, Pageable pageable) {
        return dlBookRepository.findByUserId(userId, pageable);
    }

    @Override
    public Page<User> findUsersDownloadingBook(long bookId, Pageable pageable) {
        return dlBookRepository.findUsersDownloadingBook(bookId, pageable);
    }

    @Override
    @Transactional
    public DownloadedBook downloadBook(long userId, long bookId) {
        User user = userRepository.findOne(userId);
        Book book = bookRepository.findOne(bookId);
        return dlBookRepository.save(new DownloadedBook(book, user));
    }

    @Override
    protected BookRepository getRepository() {
        return bookRepository;
    }
}
