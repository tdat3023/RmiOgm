package entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name ="assignments")
@Entity
@IdClass(AssignmentPk.class)
public class Assigment implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "pr_id")
	private Project project;
	
	private int hours;

	
	public Assigment() {
		super();
	}

	public Assigment(Employee employee, Project project, int hours) {
		super();
		this.employee = employee;
		this.project = project;
		this.hours = hours;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	
	
}
