package telran.person.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
@Entity
public class Employee extends Person {
	String company;
	int salary;

	public Employee() {
	}

	public Employee(int id, String name, LocalDate birthdate, Address address, String company, int salary) {
		super(id, name, birthdate, address);
		this.company = company;
		this.salary = salary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [company=" + company + ", salary=" + salary + ", id=" + id + ", name=" + name + ", birthdate="
				+ birthdate + ", address=" + address + "]";
	}
}
