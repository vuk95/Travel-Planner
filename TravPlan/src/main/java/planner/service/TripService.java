package planner.service;

import java.util.List;

import planner.model.Trip;

public interface TripService {
	
	public Trip findOne(Long id);
	public List<Trip> findAll();
	public Trip save(Trip trip);
	public List<Trip> findTrips(String destination, String comment);
	
}
