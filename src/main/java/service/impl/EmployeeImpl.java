package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.EmployeeDAO;
import entity.Employee;
import service.EmployeeService;

public class EmployeeImpl extends UnicastRemoteObject implements EmployeeService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeImpl() throws RemoteException {
		employeeDAO = new EmployeeDAO();
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployee();
	}

	@Override
	public Employee findEmployeeById(String id) {
		// TODO Auto-generated method stub
		return employeeDAO.findEmployeeById(id);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmpoyee(String id) {
		// TODO Auto-generated method stub
		return employeeDAO.deleteEmployee(id);
	}


	

}
