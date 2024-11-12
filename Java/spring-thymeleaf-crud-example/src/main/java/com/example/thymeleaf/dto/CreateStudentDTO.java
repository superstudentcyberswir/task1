package com.example.thymeleaf.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class CreateStudentDTO {

    @NotEmpty(message = "{NotEmpty.name}")
    @Size(min = 3, max = 50, message = "{Size.name}")
    private String name;

    @Email
    @NotEmpty(message = "{NotEmpty.email}")
    @Size(max = 100, message = "{Size.email}")
    private String email;

    @NotNull(message = "{NotNull.birthday}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotEmpty(message = "{NotEmpty.zipCode}")
    @Size(min = 5, max = 10, message = "{Size.zipCode}")
    @Pattern(regexp = "^[0-9]{5}(-?[0-9]{3})?$", message = "{Pattern.zipCode}")
    private String zipCode;

    @NotEmpty(message = "{NotEmpty.street}")
    @Size(min = 2, max = 100, message = "{Size.street}")
    @Pattern(regexp = "^[a-zA-Z0-9\\s.-]$", message = "{Pattern.street}")
    private String street;

    @NotEmpty(message = "{NotEmpty.number}")
    @Size(min = 1, max = 10, message = "{Size.number}")
    @Pattern(regexp = "^[a-zA-Z0-9\\s./-]$")
    private String number;

    @Size(max = 50, message = "{Size.complement")
    @Pattern(regexp = "^[a-zA-Z0-9\\s./-]$", message = "{Pattern.complement}")
    private String complement;

    @NotEmpty(message = "{NotEmpty.district}")
    @Size(min = 2, max = 20, message = "{Size.district}")
    @Pattern(regexp = "^[a-zA-Z\\s.-]$", message = "{Pattern.district}")
    private String district;

    @NotEmpty(message = "{NotEmpty.city}")
    @Size(min = 2, max = 50, message = "{Size.city}")
    @Pattern(regexp = "^[a-zA-Z\\s.-]$", message = "{Pattern.city}")
    private String city;

    @NotEmpty(message = "{NotEmpty.state}")
    @Size(min = 2, max = 20, message = "{Size.state}")
    @Pattern(regexp = "^[a-zA-Z\\s.-]$", message = "{Pattern.state}")
    private String state;

}
