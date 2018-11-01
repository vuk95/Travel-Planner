package planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import planner.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{
	
	List<Trip> findByDestinationIgnoreCaseContainingAndCommentIgnoreCaseContaining(String destination,String comment);

}
