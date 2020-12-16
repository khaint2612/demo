package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.Staffs;
import edu.poly.spring.repositories.StaffRepository;

@Service
public class StaffServiceImp implements StaffService{

	@Autowired
	private StaffRepository staffRepository;

	@Override
	public Staffs save(Staffs entity) {
		return staffRepository.save(entity);
	}

	@Override
	public List<Staffs> saveAll(List<Staffs> entities) {
		return (List<Staffs>)staffRepository.saveAll(entities);
	}

	@Override
	public Optional<Staffs> findById(String id) {
		return staffRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return staffRepository.existsById(id);
	}

	@Override
	public List<Staffs> findAll() {
		return (List<Staffs>)staffRepository.findAll();
	}

	@Override
	public List<Staffs> findAllById(List<String> ids) {
		return (List<Staffs>)staffRepository.findAllById(ids);
	}

	public List<Staffs> findByNameLikeOrderByName(String name) {
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
	public void delete(Staffs entity) {
		staffRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Staffs> entities) {
		staffRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		staffRepository.deleteAll();
	}
	
	
}
