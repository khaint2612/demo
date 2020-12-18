package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.models.Staffs;
import edu.poly.spring.models.User;
import edu.poly.spring.models.UserAuth;
import edu.poly.spring.repositories.UserAuthRepository;
import edu.poly.spring.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	UserAuthRepository userAuthRepository;
	
	@Override
	public UserAuth save(UserAuth entity) {
		return userAuthRepository.save(entity);
	}

	@Override
	public List<UserAuth> saveAll(List<UserAuth> entities) {
		return (List<UserAuth>) userAuthRepository.saveAll(entities);
	}

	@Override
	public Optional<UserAuth> findById(Integer id) {
		return userAuthRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return userAuthRepository.existsById(id);
	}

	@Override
	public List<UserAuth> findAll() {
		return (List<UserAuth>) userAuthRepository.findAll();
	}

	@Override
	public List<UserAuth> findAllById(List<Integer> ids) {
		return (List<UserAuth>) userAuthRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return userAuthRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		userAuthRepository.deleteById(id);
	}

	@Override
	public void delete(UserAuth entity) {
		userAuthRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<UserAuth> entities) {
		userAuthRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userAuthRepository.deleteAll();
	}
//	public boolean checkLogin(String username, String password) {
//		Optional<UserAuth> optionalUser = findByUsername(username);
//		if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
//			return true;
//		}
//		return false;
//	}
//	private Optional<UserAuth> findByUsername(String username) {
//		
//		return Optional.of(userAuthRepository.findByUsername(username));
//	}

}
