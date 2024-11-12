package com.example.thymeleaf;

import com.example.thymeleaf.dto.CreateStudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class SpringThymeleafTemplateApplicationTests {
    private Validator validator;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void incorrectInputTest_XSS() {
        CreateStudentDTO incorrect_student = new CreateStudentDTO();
        incorrect_student.setName("<script>alert(1)</script>");
        incorrect_student.setEmail("test@test.com");
        incorrect_student.setBirthday(LocalDate.now());
        incorrect_student.setZipCode("12345");
        incorrect_student.setStreet("street");
        incorrect_student.setNumber("1/23");
        incorrect_student.setDistrict("district");
        incorrect_student.setCity("city");
        incorrect_student.setState("state");

        validator.validate(incorrect_student);

        Set<ConstraintViolation<CreateStudentDTO>> violations = validator.validate(incorrect_student);

        assertFalse(violations.isEmpty(), "Validation should fail because name contains XSS content.");
    }

    @Test
    void correctInputTest() {
        CreateStudentDTO correct_student = new CreateStudentDTO();
        correct_student.setName("Test test");
        correct_student.setEmail("test@test.com");
        correct_student.setBirthday(LocalDate.now());
        correct_student.setZipCode("12345");
        correct_student.setStreet("street");
        correct_student.setNumber("1/23");
        correct_student.setDistrict("district");
        correct_student.setCity("city");
        correct_student.setState("state");

        validator.validate(correct_student);

        Set<ConstraintViolation<CreateStudentDTO>> violations = validator.validate(correct_student);

        assertTrue(violations.isEmpty(), "Validation should pass when all values are valid.");
    }

}
