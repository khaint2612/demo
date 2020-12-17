package edu.poly.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.Staff;

@Repository
public interface StaffRepository  extends CrudRepository<Staff, String>{
	List<Staff> findByNameLikeOrderByName(String name);
}
