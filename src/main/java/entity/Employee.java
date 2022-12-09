package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "employees")
@Entity
public class Employee implements Serializable{
	
	@Id
	@Column(name = "emp_id")
	private String id;
	
	private String email;
	
	private Date hireDate;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;
	
	private String name;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "phone", joinColumns = @JoinColumn(name = "emp_id"))
	@Column(name = "phone")
	private Set<String> phones;
	
	@OneToMany(mappedBy = "employee")
	private List<Assigment> assigments;
	
	public Employee() {
		super();
	}

	public Employee(String id, String email, Date hireDate,String name, Set<String> phones) {
		super();
		this.id = id;
		this.email = email;
		this.hireDate = hireDate;
		this.name = name;
		this.phones = phones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public List<Assigment> getAssigments() {
		return assigments;
	}

	public void setAssigments(List<Assigment> assigments) {
		this.assigments = assigments;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", hireDate=" + hireDate + ", manager=" + manager + ", name="
				+ name +"]";
	}
	
}
