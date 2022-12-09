package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import entity.Assigment;
import entity.Employee;
import entity.Project;

public class HibernateConfig {
	
	private static HibernateConfig instance = null;
	
	private SessionFactory sessFac;
	
	private HibernateConfig() {
		ServiceRegistry reg = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		Metadata meta = new MetadataSources(reg)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Project.class)
				.addAnnotatedClass(Assigment.class)
				.getMetadataBuilder()
				.build();
		
		sessFac = meta
				.getSessionFactoryBuilder()
				.build();
	}
	
	public synchronized static HibernateConfig getInstance() {
		if(instance == null)
			instance = new HibernateConfig();
		return instance;
	}
	
	public SessionFactory getSessionFactory() {
		return sessFac;
	}
}
