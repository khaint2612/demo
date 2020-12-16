package edu.poly.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.Library;
import edu.poly.spring.repositories.LibraryRepository;

@Service
public class LibraryServiceImp implements LibraryService{
	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public <S extends Library> S save(S entity) {
		return libraryRepository.save(entity);
	}

	@Override
	public <S extends Library> Iterable<S> saveAll(Iterable<S> entities) {
		return libraryRepository.saveAll(entities);
	}

	@Override
	public Optional<Library> findById(String id) {
		return libraryRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return libraryRepository.existsById(id);
	}

	@Override
	public Iterable<Library> findAll() {
		return libraryRepository.findAll();
	}

	@Override
	public Iterable<Library> findAllById(Iterable<String> ids) {
		return libraryRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return libraryRepository.count();
	}

	@Override
	public void deleteById(String id) {
		libraryRepository.deleteById(id);
	}

	@Override
	public void delete(Library entity) {
		libraryRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Library> entities) {
		libraryRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		libraryRepository.deleteAll();
	}
}
