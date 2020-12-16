package edu.poly.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
