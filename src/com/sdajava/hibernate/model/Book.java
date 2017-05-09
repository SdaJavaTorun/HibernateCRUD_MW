package com.sdajava.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

import static javax.persistence.GenerationType.TABLE;

/**
 * Created by RENT on 2017-05-09.
 */

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = TABLE)
    private int id;

    private String title;
    private String author;
    private Date published;
    private String description;



    public Book() {
        this.id = id;
        this.title = title;
        this.author = author;
        this.published = published;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
