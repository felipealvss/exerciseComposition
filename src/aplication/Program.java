package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner read = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// Department
		System.out.print("Enter department's name: ");
			String NameDepartment = read.nextLine();
		// Worker
		System.out.print("Enter work data: ");
		System.out.print("Name: ");
			String nameWorker = read.nextLine();
		System.out.print("Level: ");
			String levelWorker = read.nextLine();
		System.out.print("Base salary: ");
			double bsWorker = read.nextDouble();
		
		// Worker's Instance
		Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(levelWorker), bsWorker, new Department(NameDepartment)); // A new Department was instantiated within the instance of a new Worker
		
		// Contracts
		System.out.print("How many contracts to this worker?: ");
			int numberContracts = read.nextInt();
				for (int i = 0; i < numberContracts; i++) {
					System.out.printf("Enter contract #%n data: ", i + 1);
					System.out.print("Date (DD/MM/YYYY): ");
						Date dateContract = sdf.parse(read.next());
					System.out.print("Value per hour: ");
						double vph = read.nextDouble();
					System.out.print("Duration(hours): ");
						int hourDuration = read.nextInt();
						
					// Contract's Instance
					HourContract contract = new HourContract(dateContract, vph, hourDuration);
					// Definition of a NEW Contract to the Worker
					worker.addContract(contract);
				}
		
		// Show the informations
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
			String monthAndYear = read.next(); // Now, we will divide to receive separately two attributes
				int month = Integer.parseInt(monthAndYear.substring(0, 2)); // Here, we assign a value to the attribute 'month'
				int year = Integer.parseInt(monthAndYear.substring(3)); // And here, we assign a value to the attribute 'year'
		System.out.println();
		System.out.print("Name: " + worker.getName());
		System.out.print("Department: " + worker.getDepartment().getName());
		System.out.print("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
			
		read.close();
	}

}
