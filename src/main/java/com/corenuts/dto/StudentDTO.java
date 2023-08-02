package com.corenuts.dto;

import java.sql.Date;

//@Buildes

//@Service
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentDTO {

    private int student_id;

    @NotBlank(message = "Student name is required")
    private String student_name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must contain at least one special character and one uppercase letter")
    private String password;

    private String status;

    @NotNull(message = "Batch ID is required")
    private int batch_id;

    private Date created_on;
}

