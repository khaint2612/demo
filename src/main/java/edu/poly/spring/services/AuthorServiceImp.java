package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.Author;
import edu.poly.spring.repositories.AuthorRepository;

@Service
public class AuthorServiceImp implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public <S extends Author> S save(S entity) {
		return authorRepository.save(entity);
	}

	@Override
	public <S extends Author> Iterable<S> saveAll(Iterable<S> entities) {
		return authorRepository.saveAll(entities);
	}

	@Override
	public Optional<Author> findById(String id) {
		return authorRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return authorRepository.existsById(id);
	}

	@Override
	public Iterable<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public Iterable<Author> findAllById(Iterable<String> ids) {
		return authorRepository.findAllById(ids);
	}

	@Override
	public List<Author> findByNameLikeOrderByName(String name) {
		return authorRepository.findByNameLikeOrderByName( "%" + name + "%" );
	}

	@Override
	public long count() {
		return authorRepository.count();
	}

	@Override
	public void deleteById(String id) {
		authorRepository.deleteById(id);
	}

	@Override
	public void delete(Author entity) {
		authorRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Author> entities) {
		authorRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		authorRepository.deleteAll();
	}
	
}
