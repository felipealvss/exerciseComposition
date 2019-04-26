package entities;

import java.util.Date;

public class HourContract {

	// Arguments
	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	// Construct without arguments - standard constructor
	public HourContract() {}
	// Construct with arguments
	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}
	
	// GET&SET
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getValuePerHour() {
		return valuePerHour;
	}
	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	// Class Methods 
	public double totalValue() {
		double totValue;
		totValue = getHours() * getValuePerHour();
		return totValue;
	}

}
