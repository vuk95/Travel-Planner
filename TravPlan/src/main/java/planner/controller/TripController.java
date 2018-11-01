package planner.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import planner.converters.TripDTOtoTrip;
import planner.converters.TripToTripDTO;
import planner.dto.TripDTO;
import planner.model.Trip;
import planner.service.TripService;

@RestController
@RequestMapping(value = "/planner")
public class TripController {
	
	@Autowired
	private TripService tripService;
	
	@Autowired
	private TripToTripDTO toTripDTO;
	
	@Autowired
	private TripDTOtoTrip toTrip;
	
	@RequestMapping(value="getTrips", method = RequestMethod.GET)
	public ResponseEntity<List<TripDTO>> getTrips() {

		List<Trip> trips = tripService.findAll();
		
		for(int i = 0; i < trips.size(); i++) {
			
			Date now = new Date();
			
			long diff = trips.get(i).getStartDate().getTime() - now.getTime();
			
			if(trips.get(i).getStartDate().getTime() >= now.getTime()) {
				trips.get(i).setDayCount(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
			}
		
		}
		
		return new ResponseEntity<>(toTripDTO.convert(trips), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> addTrips(@RequestBody TripDTO tripDTO){
		
		Trip newTrip = tripService.save(toTrip.convert(tripDTO));
		
		return new ResponseEntity<>(toTripDTO.convert(newTrip), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findTrips", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<List<TripDTO>> find(@RequestParam(value = "destination", required = true, defaultValue = "") String destination, 
			@RequestParam(value = "comment", required = false, defaultValue = "") String comment){
		
		List<Trip> trips = tripService.findTrips(destination, comment);
		
		return new ResponseEntity<>(toTripDTO.convert(trips), HttpStatus.OK);
	}
}
