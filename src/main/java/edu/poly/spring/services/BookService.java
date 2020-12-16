package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spring.models.Author;
import edu.poly.spring.models.Book;
import edu.poly.spring.models.Category;
import edu.poly.spring.models.PublishingCompany;


public interface BookService {

	void deleteAll();

	void deleteAll(Iterable<? extends Book> entities);

	void delete(Book entity);

	void deleteById(String id);

	long count();

	Iterable<Book> findAllById(Iterable<String> ids);

	Iterable<Book> findAll();

	boolean existsById(String id);

	Optional<Book> findById(String id);

	<S extends Book> Iterable<S> saveAll(Iterable<S> entities);

	<S extends Book> S save(S entity);

	List<Book> findByNameLikeOrderByName(String name);

	List<Author> findAllAuthor();

	List<Category> findAllCategory();

	List<PublishingCompany> findAllPublishingCompany();



}
