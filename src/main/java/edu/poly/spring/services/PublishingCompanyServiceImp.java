package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.PublishingCompany;
import edu.poly.spring.repositories.PublishingCompanyRepository;

@Service
public class PublishingCompanyServiceImp implements PublishingCompanyService{
	@Autowired
	private PublishingCompanyRepository publishingCompanyRepository;

	@Override
	public <S extends PublishingCompany> S save(S entity) {
		return publishingCompanyRepository.save(entity);
	}
	@Override
	public List<PublishingCompany> findByNameLikeOrderByName(String name) {
		return publishingCompanyRepository.findByNameLikeOrderByName("%" + name + "%");
	}
	@Override
	public <S extends PublishingCompany> Iterable<S> saveAll(Iterable<S> entities) {
		return publishingCompanyRepository.saveAll(entities);
	}

	@Override
	public Optional<PublishingCompany> findById(String id) {
		return publishingCompanyRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return publishingCompanyRepository.existsById(id);
	}

	@Override
	public Iterable<PublishingCompany> findAll() {
		return publishingCompanyRepository.findAll();
	}

	@Override
	public Iterable<PublishingCompany> findAllById(Iterable<String> ids) {
		return publishingCompanyRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return publishingCompanyRepository.count();
	}

	@Override
	public void deleteById(String id) {
		publishingCompanyRepository.deleteById(id);
	}

	@Override
	public void delete(PublishingCompany entity) {
		publishingCompanyRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends PublishingCompany> entities) {
		publishingCompanyRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		publishingCompanyRepository.deleteAll();
	}
	
}
