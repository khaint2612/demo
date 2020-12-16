package edu.poly.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {
	List<Category> findByNameLikeOrderByName(String name);
}
