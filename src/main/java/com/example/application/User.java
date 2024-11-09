package com.example.application;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class User {
  private String firstName;
  private LocalDateTime dateOfBirth;
  private String email;

  public User(String firstName, LocalDateTime dateOfBirth, String email) {
    this.firstName = firstName;
    this.dateOfBirth = dateOfBirth;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public LocalDateTime getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDateTime dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
