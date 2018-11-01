package planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import planner.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findOneByEmail(String email);
}
