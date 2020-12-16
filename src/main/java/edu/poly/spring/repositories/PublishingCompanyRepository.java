package edu.poly.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.models.PublishingCompany;

@Repository
public interface PublishingCompanyRepository extends CrudRepository<PublishingCompany, String> {
	List<PublishingCompany> findByNameLikeOrderByName(String name);
}
