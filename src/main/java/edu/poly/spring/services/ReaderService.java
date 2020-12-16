package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spring.models.Reader;
import edu.poly.spring.models.Staffs;

public interface ReaderService {

	void deleteAll();

	void deleteAll(List<Reader> entities);

	void delete(Reader entity);

	void deleteById(String id);

	long count();

	Iterable<Reader> findAllById(Iterable<String> ids);

	Iterable<Reader> findAll();

	boolean existsById(String id);

	Optional<Reader> findById(String id);

	List<Reader> saveAll(Iterable<Reader> entities);

	Reader save(Reader entity);

	List<Staffs> findAllStaff();

	List<Reader> findByNameLikeOrderByName(String name);

}
