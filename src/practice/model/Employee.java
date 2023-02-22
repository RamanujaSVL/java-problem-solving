package practice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Employee {

    private String employeeName;
    private Integer employeeAge;
    private String employeeCountry;
    private String errorMessage;
}
