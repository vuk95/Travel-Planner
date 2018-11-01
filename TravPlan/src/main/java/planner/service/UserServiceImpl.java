package planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import planner.model.User;
import planner.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUserById(Long Id) {
		return userRepository.getOne(Id);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
