package telran.person.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	String city;
	String street;
	int building;
	public Address() {
	}
	public Address(String city, String street, int building) {
		this.city = city;
		this.street = street;
		this.building = building;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getBuilding() {
		return building;
	}
	public void setBuilding(int building) {
		this.building = building;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", building=" + building + "]";
	}
	
}
