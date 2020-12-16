package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.Category;
import edu.poly.spring.repositories.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	@Override
	public <S extends Category> Iterable<S> saveAll(Iterable<S> entities) {
		return categoryRepository.saveAll(entities);
	}

	@Override
	public Optional<Category> findById(String id) {
		return categoryRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return categoryRepository.existsById(id);
	}

	@Override
	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Iterable<Category> findAllById(Iterable<String> ids) {
		return categoryRepository.findAllById(ids);
	}

	@Override
	public List<Category> findByNameLikeOrderByName(String name) {
		return categoryRepository.findByNameLikeOrderByName("%" + name + "%");
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void deleteById(String id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Category> entities) {
		categoryRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}
	
}
