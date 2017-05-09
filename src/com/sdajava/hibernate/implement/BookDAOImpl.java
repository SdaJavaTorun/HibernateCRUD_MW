package com.sdajava.hibernate.implement;

import com.sdajava.hibernate.interfaces.BookDAO;
import com.sdajava.hibernate.model.Book;
import com.sdajava.hibernate.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by RENT on 2017-05-09.
 */


public class BookDAOImpl implements BookDAO {

    Session session = HibernateUtility.getHibernateSession();

    @Override
    public Book insertBook(Book book){
        try {
            System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getPublished() + book.getDescription());
            session.beginTransaction();
            session.persist(book);
            session.getTransaction().commit();
        }catch (HibernateException e){
        if (session.getTransaction() != null) session.getTransaction().rollback();
        e.printStackTrace();
    }

        return book;
    }


    @Override
    public List<Book> getAllBooks() {
        List<Book> books = null;

        try{
        session.beginTransaction();
        books = session.createQuery("From Book").list();

        for (Iterator<Book> bookIterator =
        books.iterator(); bookIterator.hasNext();) {
            Book book = (Book) bookIterator.next();

            System.out.println(" " + book.getTitle() + "\t");
            System.out.println(" " + book.getAuthor() + "\t");
            System.out.println(" " + book.getPublished() + "\t");
            System.out.println("" +  book.getDescription() + "\t");
        }
        }catch (HibernateException e){
            if (session.getTransaction()!=null) session.getTransaction().rollback();
            e.printStackTrace();
        }
       return books;

    }


    @Override
    public void updateBook(int id, String title, String author, Date published, String description) {
        try {
            session.beginTransaction();
            Book book = session.get(Book.class, id);
            System.out.println(" " + book.getTitle());

            book.setTitle(title);
            book.setAuthor(author);
            book.setPublished(published);
            book.setDescription(description);
        } catch (HibernateException e) {
            if (session.getTransaction()!=null) session.getTransaction().rollback();
            e.printStackTrace();
        }
    }



    @Override
    public void removeBook(int id) {

        try {
            Book book = session.get(Book.class, id);

            System.out.println(" " + book.getTitle() + "\t");
            System.out.println(" " + book.getAuthor() + "\t");
            System.out.println(" " + book.getPublished() + "\t");
            System.out.println("" +  book.getDescription() + "\t");

            session.delete(book);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction()!=null) session.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    @Override
    public Book findBook(int id) {
        Book book = session.get(Book.class, id);

        System.out.println(" " + book.getTitle() + "\t");
        System.out.println(" " + book.getAuthor() + "\t");
        System.out.println(" " + book.getPublished() + "\t");
        System.out.println("" +  book.getDescription() + "\t");

        return book;


    }
}

