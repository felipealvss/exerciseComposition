package entities;

public class Department {

	// Arguments
	private String name;
	
	// Construct without fields
	public Department() {}
	// Construct with fields
	public Department(String name) {
		this.name = name;
	}
	
	// GET&SET
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
