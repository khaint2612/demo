package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spring.models.Staff;

public interface StaffService {

	void deleteAll();

	void deleteAll(List<Staff> entities);

	void delete(Staff entity);

	void deleteById(String id);

	long count();

	List<Staff> findByNameLikeOrderByName(String name);

	List<Staff> findAllById(List<String> ids);

	Iterable<Staff> findAll();

	boolean existsById(String id);

	Optional<Staff> findById(String id);

	List<Staff> saveAll(List<Staff> entities);

	Staff save(Staff entity);

}
