package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.Staff;
import edu.poly.spring.repositories.StaffRepository;

@Service
public class StaffServiceImp implements StaffService{

	@Autowired
	private StaffRepository staffRepository;

	@Override
	public Staff save(Staff entity) {
		return staffRepository.save(entity);
	}

	@Override
	public List<Staff> saveAll(List<Staff> entities) {
		return (List<Staff>)staffRepository.saveAll(entities);
	}

	@Override
	public Optional<Staff> findById(String id) {
		return staffRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return staffRepository.existsById(id);
	}

	@Override
	public Iterable<Staff> findAll() {
		return staffRepository.findAll();
	}

	@Override
	public List<Staff> findAllById(List<String> ids) {
		return (List<Staff>)staffRepository.findAllById(ids);
	}

	public List<Staff> findByNameLikeOrderByName(String name) {
		return staffRepository.findByNameLikeOrderByName("%"+ name +"%");
	}

	@Override
	public long count() {
		return staffRepository.count();
	}

	@Override
	public void deleteById(String id) {
		staffRepository.deleteById(id);
	}

	@Override
	public void delete(Staff entity) {
		staffRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Staff> entities) {
		staffRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		staffRepository.deleteAll();
	}
	
	
}
