package com.luv2code.spring.demo.mvc;

import com.luv2code.spring.demo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")// this is the massage that appear if validation is broke
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "should be more than or equal to zero")
    @Max(value = 10, message = "should be less than or equal to 10")
    private Integer freePasses;


    @Pattern(regexp = "^[a-zA-z0-9]{5}", message = "Enter 5 digits only")
    private String postalCode;

    @CourseCode(value = "hamoodah",message = "must start with hamoodah")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
