package telran.person.domain;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Child extends Person {
	String kindergarten;

	public Child() {
	}

	public Child(int id, String name, LocalDate birthdate, Address address, String kindergarten) {
		super(id, name, birthdate, address);
		this.kindergarten = kindergarten;
	}

	public String getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(String kindergarten) {
		this.kindergarten = kindergarten;
	}

	@Override
	public String toString() {
		return "Child [kindergarten=" + kindergarten + ", id=" + id + ", name=" + name + ", birthdate=" + birthdate
				+ ", address=" + address + "]";
	}
}
