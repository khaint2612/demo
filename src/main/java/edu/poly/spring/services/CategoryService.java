package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spring.models.Category;

public interface CategoryService {

	void deleteAll();

	void deleteAll(Iterable<? extends Category> entities);

	void delete(Category entity);

	void deleteById(String id);

	long count();

	Iterable<Category> findAllById(Iterable<String> ids);

	Iterable<Category> findAll();

	boolean existsById(String id);

	Optional<Category> findById(String id);

	<S extends Category> Iterable<S> saveAll(Iterable<S> entities);

	<S extends Category> S save(S entity);

	List<Category> findByNameLikeOrderByName(String name);

}
