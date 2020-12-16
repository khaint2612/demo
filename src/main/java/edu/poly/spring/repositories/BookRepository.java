package edu.poly.spring.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
	List<Book> findByNameLikeOrderByName(String name);
	
}
