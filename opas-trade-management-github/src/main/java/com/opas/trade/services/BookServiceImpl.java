package com.opas.trade.services;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.opas.trade.domain.Book;

@Component("bookService")
class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	@Transactional(readOnly = false)
	public Book save(Book book) {
		return bookRepository.save(book);
	}

}
