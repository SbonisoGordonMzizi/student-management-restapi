package co.za.tech.studentmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    @NotEmpty(message = "FirstName can not be Empty")
    private String firstName;
    @NotEmpty(message = "LastName can not be Empty")
    private String lastName;
    @NotBlank(message = "Gender can not be Empty")
    @Size(min = 1,max = 1)
    private String gender;
    @Min(14)
    @Max(35)
    private Integer age;

}
