package edu.poly.spring.services;

import java.util.Optional;

import edu.poly.spring.models.Library;

public interface LibraryService {

	void deleteAll();

	void deleteAll(Iterable<? extends Library> entities);

	void delete(Library entity);

	void deleteById(String id);

	long count();

	Iterable<Library> findAllById(Iterable<String> ids);

	Iterable<Library> findAll();

	boolean existsById(String id);

	Optional<Library> findById(String id);

	<S extends Library> Iterable<S> saveAll(Iterable<S> entities);

	<S extends Library> S save(S entity);

}
