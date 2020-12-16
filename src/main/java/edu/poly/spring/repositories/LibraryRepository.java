package edu.poly.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library, String>{

}
