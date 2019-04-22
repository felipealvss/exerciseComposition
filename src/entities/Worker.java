package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	// Attributes from the class itself
	private String name;
	private WorkerLevel level;
	private double baseSalary;
	// Relation to the table Department, having only one relationship
	private Department department;
	// Relation to the table HouContracts, having many relationships, so using a list
	private List<HourContract> contracts = new ArrayList<>(); // Put the ArrayList here on the declaration
	
	// Construct without arguments
	public Worker() {}
	// Construct with arguments
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
		// You won't put any attributes that is a list type here on the constructor
	}
	
	// GET&SET
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<HourContract> getContracts() {
		return contracts;
	}
	// If already have methods to add or remove contracts, there is no need to have a setContract method.
	
	// Class methods
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removecontract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance(); // Using the Calendar to be able to get date components 
			for (HourContract workerContract : contracts) {
				cal.setTime(workerContract.getDate());
				int yearWorkerContract = cal.get(Calendar.YEAR); // Get the year from the date
				int monthWorkerContract = 1 + cal.get(Calendar.MONTH); // Get the month from the date, add 1 because the month starts at 0 by default 
					if (year == yearWorkerContract && month == monthWorkerContract) { // The condition defines that the month and year must be the same as those passed in the parameter 
						sum += workerContract.totalValue();
					}
			}
		return sum;
	}
}
