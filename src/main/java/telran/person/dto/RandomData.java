package telran.person.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class RandomData {
    private int n_persons;
    private int n_names;
    private int n_cities;
    private int n_streets;
    private int n_buildings;
    private int min_id;
    private int min_salary;
    private int max_salary;
    private int n_companies;
    private int percent_empl;
    private int n_gartens;
}
