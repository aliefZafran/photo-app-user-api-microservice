package com.udemyspringboot.photoapp.api.users.ui.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//model for request body
//client will input data here
public class CreateUserRequestModel {

    @NotNull(message = "Please enter first name")
    @Size(min=2, message="First name must be more than 2 characters")
    private String firstName;

    @NotNull(message = "Please enter last name")
    @Size(min=2, message="Last name must be more than 2 characters")
    private String lastName;

    @NotNull(message = "Password cannot be blank")
    private String password;

    @NotNull(message = "Email cannot be blank")
    @Email
    private String email;

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
