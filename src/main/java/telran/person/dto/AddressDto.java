package telran.person.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressDto {
	String city;
	String street;
	public String getStreet() {
		return street;
	}
	int building;
	public int getBuilding() {
		
		return building;
	}
	public String getCity() {
		return city;
	}

}
