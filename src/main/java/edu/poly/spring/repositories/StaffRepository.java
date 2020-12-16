package edu.poly.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.Staffs;

@Repository
public interface StaffRepository  extends CrudRepository<Staffs, String>{
	List<Staffs> findByNameLikeOrderByName(String name);
}
