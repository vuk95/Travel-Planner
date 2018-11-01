package planner.converters;


import org.springframework.stereotype.Component;

import planner.dto.TripDTO;
import planner.model.Trip;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

@Component
public class TripDTOtoTrip implements Converter<TripDTO, Trip>{

	@Override
	public Trip convert(TripDTO source) {
		
		if(source == null) {
			return null;
		}
				
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		
		Trip trip = new Trip();
		trip.setId(source.getId());
		try {
			trip.setStartDate(inputFormat.parse(source.getStartDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			trip.setEndDate(inputFormat.parse(source.getEndDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		trip.setDestination(source.getDestination());
		trip.setComment(source.getComment());
		
		return trip;
	}
	
	public List<Trip> convert(List<TripDTO> source){
		
		List<Trip> trips = new ArrayList<Trip>();
		for(TripDTO tripDTO : source) {
			trips.add(convert(tripDTO));
		}
		
		return trips;
		
	}

}
