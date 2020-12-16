package edu.poly.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.Author;
@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {
	List<Author> findByNameLikeOrderByName(String name);
}
