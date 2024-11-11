package com.example.application.data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class User {

  @NotEmpty(message = "Please enter First Name")
  private String firstName;
  @NotNull(message = "Please enter Birthday")
  private LocalDate dateOfBirth;
  private String email;

  public User(String firstName, LocalDate dateOfBirth, String email) {
    this.firstName = firstName;
    this.dateOfBirth = dateOfBirth;
    this.email = email;
  }

  public User() {
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
