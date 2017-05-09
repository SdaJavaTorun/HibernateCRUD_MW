package com.sdajava.hibernate;

import com.sdajava.hibernate.implement.BookDAOImpl;
import com.sdajava.hibernate.model.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {

	public static void main(String[] args) {


		BookDAOImpl bookDAOimpl = new BookDAOImpl();
		Date simpleDateFormat = null;

		try {
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-12");
		} catch (ParseException e) {
			e.printStackTrace();
		}


		Book book = new Book();
		book.setTitle("Programowania Java");
		book.setAuthor("Jarek Browarek");
		book.setPublished(simpleDateFormat);
		book.setDescription("Ksiązka o programowaniu");
		bookDAOimpl.insertBook(book);
		bookDAOimpl.getAllBooks();
	}
}

