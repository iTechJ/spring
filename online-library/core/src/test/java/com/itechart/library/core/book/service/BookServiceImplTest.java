package com.itechart.library.core.book.service;

import com.itechart.library.core.CommonTransactionalSpringTest;
import com.itechart.library.core.book.Book;
import com.itechart.library.core.book.DownloadedBook;
import com.itechart.library.core.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;


public class BookServiceImplTest extends CommonTransactionalSpringTest {
    private static final long TEST_BOOK_ID = 1;
    private static final long TEST_ANOTHER_BOOK_ID = 2;
    private static final long TEST_ADMIN_ID = 1;
    private static final long TEST_USER_ID = 2;


    @Autowired
    private BookService bookService;

    @Test
    public void testFindDownloadedBooks() throws Exception {
        downloadBooks();

        Page<DownloadedBook> bookPage = bookService.findDownloadedBooks(TEST_USER_ID, buildPage(0));
        assertPage(bookPage, 2);
    }

    private void downloadBooks() {
        bookService.downloadBook(TEST_ADMIN_ID, TEST_BOOK_ID);
        bookService.downloadBook(TEST_USER_ID, TEST_BOOK_ID);
        bookService.downloadBook(TEST_USER_ID, TEST_ANOTHER_BOOK_ID);
    }

    private void assertPage(Page<?> page, int expectedCount) {
        Assert.assertNotNull(page);
        Assert.assertEquals(expectedCount, page.getTotalElements());
        Assert.assertEquals(expectedCount, page.getContent().size());
    }

    @Test
    public void testFindUsersDownloadingBook() throws Exception {
        downloadBooks();

        Page<User> userPage = bookService.findUsersDownloadingBook(TEST_BOOK_ID, buildPage(0));
        assertPage(userPage, 2);

    }

    @Test
    public void testFindAllBooks() throws Exception {
        Page<Book> page = bookService.findAll(buildPage(0));

        Assert.assertNotNull(page);
        Assert.assertNotEquals(0, page.getTotalElements());
        Assert.assertNotEquals(0, page.getTotalPages());
        Assert.assertFalse(page.getContent().isEmpty());
    }
}