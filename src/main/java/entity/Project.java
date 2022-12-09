package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name ="projects")
@Entity
public class Project implements Serializable{
	private double budget;
	
	@Id
	@Column(name ="pr_id")
	private String id;
	
	private String name;
	
	private Date startDate;
	
	@OneToMany(mappedBy = "project")
	private List<Assigment> assigments;
	
	public Project() {
		super();
	}

	public Project(double budget, String id, String name, Date startDate, List<Assigment> assigments) {
		super();
		this.budget = budget;
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.assigments = assigments;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Assigment> getAssigments() {
		return assigments;
	}

	public void setAssigments(List<Assigment> assigments) {
		this.assigments = assigments;
	}

	@Override
	public String toString() {
		return "Project [budget=" + budget + ", id=" + id + ", name=" + name + ", startDate=" + startDate
				+ "]";
	}
	
	
}
