package com.sdajava.hibernate.interfaces;

import com.sdajava.hibernate.model.Book;

import java.util.Date;
import java.util.List;

/**
 * Created by RENT on 2017-05-09.
 */
public interface BookDAO {
    Book insertBook (Book book);

    List<Book> getAllBooks();

    void updateBook(int id, String title, String author, Date published, String description);


    void removeBook (int id);

    Book findBook (int id);





}
