package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.print("Department's name: ");
		String departmentName = sc.nextLine();
		System.out.print("Pay day: ");
		Integer payDay = sc.nextInt();
		System.out.print("E-mail: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Phone number: ");
		String phone = sc.nextLine();
		
		Address address = new Address(email, phone);
		Department dept = new Department(departmentName, payDay, address);
		
		System.out.print("How many employees does the department have?: ");
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			System.out.printf("Employee %d: ", i);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee employees = new Employee(name, salary);
			dept.addEmployee(employees);
		}
		
		showReport(dept);
		
		sc.close();

	}
	
	private static void showReport(Department dept) {
		
		System.out.println(dept);
			
		}		
		
	}


