package planner.service;

import java.util.List;

import planner.model.User;

public interface UserService {
	
	User getUserById(Long id);
	User getUserByEmail(String email);
	List<User> getAllUsers();
	
}
