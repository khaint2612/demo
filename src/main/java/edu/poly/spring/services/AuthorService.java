package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spring.models.Author;

public interface AuthorService {

	void deleteAll();

	void deleteAll(Iterable<? extends Author> entities);

	void delete(Author entity);

	void deleteById(String id);

	long count();

	Iterable<Author> findAllById(Iterable<String> ids);

	Iterable<Author> findAll();

	boolean existsById(String id);

	Optional<Author> findById(String id);

	<S extends Author> Iterable<S> saveAll(Iterable<S> entities);

	<S extends Author> S save(S entity);

	List<Author> findByNameLikeOrderByName(String name);

}
