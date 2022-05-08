package entities;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private String name;
	private Integer payDay;

	private List<Employee> employees = new ArrayList<Employee>();

	private Address address = new Address();

	public Department() {

	}

	public Department(String name, Integer payDay, Address address) {
		this.name = name;
		this.payDay = payDay;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPayDay() {
		return payDay;
	}

	public void setPayDay(Integer payDay) {
		this.payDay = payDay;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

	public Double payRoll() {
		Double sum = 0.0;
		for (Employee emp : employees) {
			sum += emp.getSalary();
		}

		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nPAYROLL\n");
		sb.append("SALES Department = R$ ");
		sb.append(String.format("%.2f", payRoll()) + "\n");
		sb.append("Payment made on day: ");
		sb.append(getPayDay() + "\n");
		sb.append("Employees:\n");
		for(Employee emp : employees) {
			sb.append(emp.getName() + "\n");	
		}
		sb.append("For questions, please contact: " + address.getEmail());
		return sb.toString();
	}

}
