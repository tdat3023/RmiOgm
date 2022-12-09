package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Employee;
import util.HibernateConfig;

public class EmployeeDAO {
	private SessionFactory sessionFactory;

	public EmployeeDAO() {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}
	
	public List<Employee> getAllEmployee(){
		Session session = sessionFactory.openSession();
		
		try {
			String query = "select * from employees";
			List<Employee> employees = session.createNativeQuery(query, Employee.class).getResultList();
			
			return employees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Employee findEmployeeById(String id) {
		Session session = sessionFactory.openSession();
		try {
			Employee employee = session.find(Employee.class, id);
			
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		
		try {
			transaction.begin();
			
			session.persist(employee);
			
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updateEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		
		try {
			transaction.begin();
			
			session.merge(employee);
			
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean deleteEmployee(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		Employee employee = findEmployeeById(id);
		
		try {
			transaction.begin();
			
			session.delete(employee);
			
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
