package com.example.application.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "USER_")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgenerator")
  // The initial value is to account for data.sql demo data ids
  @SequenceGenerator(name = "idgenerator", initialValue = 1000)
  private Long id;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
