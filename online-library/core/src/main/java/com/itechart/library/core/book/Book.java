package com.itechart.library.core.book;

import com.itechart.library.core.entity.Entity;
import org.hibernate.annotations.BatchSize;

import javax.persistence.Column;
import java.math.BigDecimal;

@javax.persistence.Entity
public class Book extends Entity {
    private String author;
    private String title;
    private String description;
    private String publicationYear;
    private BigDecimal price;

    @Column
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
