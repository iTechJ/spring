package com.itechart.library.core.book.repository;

import com.itechart.library.core.book.DownloadedBook;
import com.itechart.library.core.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DownloadedBookRepositoryCustom {
    Page<DownloadedBook> findByUserId(long userId, Pageable pageable);

    Page<User> findUsersDownloadingBook(long bookId, Pageable pageable);
}
