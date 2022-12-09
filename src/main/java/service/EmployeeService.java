package service;

import java.rmi.Remote;
import java.util.List;

import entity.Employee;

public interface EmployeeService extends Remote{
	
	public List<Employee> getAllEmployee()throws Exception;
	public Employee findEmployeeById(String id)throws Exception;
	public boolean addEmployee(Employee employee)throws Exception;
	public boolean updateEmployee(Employee employee)throws Exception;
	public boolean deleteEmpoyee(String id)throws Exception;
}
