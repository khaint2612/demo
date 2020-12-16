package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spring.models.PublishingCompany;

public interface PublishingCompanyService {

	void deleteAll();

	void deleteAll(Iterable<? extends PublishingCompany> entities);

	void delete(PublishingCompany entity);

	void deleteById(String id);

	long count();

	Iterable<PublishingCompany> findAllById(Iterable<String> ids);

	Iterable<PublishingCompany> findAll();

	boolean existsById(String id);

	Optional<PublishingCompany> findById(String id);

	<S extends PublishingCompany> Iterable<S> saveAll(Iterable<S> entities);

	<S extends PublishingCompany> S save(S entity);

	List<PublishingCompany> findByNameLikeOrderByName(String name);

}
