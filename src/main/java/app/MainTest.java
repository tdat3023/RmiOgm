package app;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.hibernate.SessionFactory;

import dao.EmployeeDAO;
import entity.Employee;
import util.HibernateConfig;

public class MainTest {
	public static void main(String[] args) {
		
		//SessionFactory sessFac = HibernateConfig.getInstance().getSessionFactory();
		
		EmployeeDAO empDAO = new EmployeeDAO();
		
		// add 
		Employee emp = new Employee("E1", "vominhphuongk2@gmail.com", new Date(), "minh phuong", new HashSet<String>(Arrays.asList("123123")));
//		empDAO.updateEmployee(emp);
		// find
//		System.out.println("Employee by id: " + empDAO.findEmployeeById("E1"));
//		System.out.println("Employees: " + empDAO.getAllEmployee());
	}
}
