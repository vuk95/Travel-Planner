package planner.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import planner.dto.TripDTO;
import planner.model.Trip;

@Component
public class TripToTripDTO implements Converter<Trip, TripDTO>{

	@Override
	public TripDTO convert(Trip source) {

		if(source == null) {
			return null;
		}
		
		ModelMapper modelMapper = new ModelMapper();
		TripDTO tripDTO = modelMapper.map(source, TripDTO.class);
		
		return tripDTO;
	}
	
	public List<TripDTO> convert(List<Trip> source){
		
		List<TripDTO> tripDTO = new ArrayList<TripDTO>();
		for (Trip trip : source) {
			tripDTO.add(convert(trip));
		}
		
		return tripDTO;
	}

}
