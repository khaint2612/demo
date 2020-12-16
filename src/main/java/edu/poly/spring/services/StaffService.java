package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spring.models.Staffs;

public interface StaffService {

	void deleteAll();

	void deleteAll(List<Staffs> entities);

	void delete(Staffs entity);

	void deleteById(String id);

	long count();

	List<Staffs> findByNameLikeOrderByName(String name);

	List<Staffs> findAllById(List<String> ids);

	Iterable<Staffs> findAll();

	boolean existsById(String id);

	Optional<Staffs> findById(String id);

	List<Staffs> saveAll(List<Staffs> entities);

	Staffs save(Staffs entity);

}
