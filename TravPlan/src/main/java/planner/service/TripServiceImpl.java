package planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import planner.model.Trip;
import planner.repository.TripRepository;

@Service
public class TripServiceImpl implements TripService{

	@Autowired
	private TripRepository tripRepository;
	
	@Override
	public Trip findOne(Long id) {
		return tripRepository.getOne(id);
	}

	@Override
	public List<Trip> findAll() {
		return tripRepository.findAll();
	}

	@Override
	public Trip save(Trip trip) {
		return tripRepository.save(trip);
	}

	@Override
	public List<Trip> findTrips(String destination, String comment) {

		return tripRepository.findByDestinationIgnoreCaseContainingAndCommentIgnoreCaseContaining(destination, comment);
	}

}
