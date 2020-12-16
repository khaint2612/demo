package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.Reader;
import edu.poly.spring.models.Staffs;
import edu.poly.spring.repositories.ReaderRepository;
import edu.poly.spring.repositories.StaffRepository;

@Service
public class ReaderServiceImp  implements ReaderService{

	@Autowired
	private ReaderRepository readerRepository;
	
	@Autowired
	private StaffRepository staffrepository;

	@Override
	public List<Staffs> findAllStaff(){
		return (List<Staffs>) staffrepository.findAll();
	}
	@Override
	public List<Reader> findByNameLikeOrderByName(String name) {
		return readerRepository.findByNameLikeOrderByName("%"+ name +"%");
	}
	@Override
	public Reader save(Reader entity) {
		return readerRepository.save(entity);
	}

	@Override
	public List<Reader> saveAll(Iterable<Reader> entities) {
		return (List<Reader>)readerRepository.saveAll(entities);
	}

	@Override
	public Optional<Reader> findById(String id) {
		return readerRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return readerRepository.existsById(id);
	}

	@Override
	public Iterable<Reader> findAll() {
		return readerRepository.findAll();
	}

	@Override
	public Iterable<Reader> findAllById(Iterable<String> ids) {
		return readerRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return readerRepository.count();
	}

	@Override
	public void deleteById(String id) {
		readerRepository.deleteById(id);
	}

	@Override
	public void delete(Reader entity) {
		readerRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Reader> entities) {
		readerRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		readerRepository.deleteAll();
	}

	
	
	
	
}
