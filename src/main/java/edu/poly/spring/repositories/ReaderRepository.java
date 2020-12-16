package edu.poly.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.Reader;
import edu.poly.spring.models.Staffs;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, String> {
	List<Reader> findByNameLikeOrderByName(String name);
	
}
