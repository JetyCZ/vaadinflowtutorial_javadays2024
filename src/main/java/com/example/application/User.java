package com.example.application;

import java.time.LocalDate;

public class User {
  private String firstName;
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
