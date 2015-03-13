package com.itechart.library.core.book;

import com.itechart.library.core.entity.Entity;
import com.itechart.library.core.user.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Calendar;
import java.util.Date;

@javax.persistence.Entity
public class DownloadedBook extends Entity {
    private Book book;
    private User user;
    private Date date;

    private DownloadedBook() {
    }

    public DownloadedBook(Book book, User user) {
        this.book = book;
        this.user = user;
        date = Calendar.getInstance().getTime();
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "BOOK_ID")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
