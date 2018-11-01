package planner.dto;

import javax.validation.constraints.NotEmpty;

public class TripDTO {
	
	private Long id;
	@NotEmpty
	private String destination;
	@NotEmpty
	private String startDate;
	@NotEmpty
	private String endDate;
	@NotEmpty
	private String comment;
	private Long dayCount;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getDayCount() {
		return dayCount;
	}
	public void setDayCount(Long dayCount) {
		this.dayCount = dayCount;
	}

}
