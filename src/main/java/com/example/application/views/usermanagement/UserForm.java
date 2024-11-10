package com.example.application.views.usermanagement;

import com.example.application.data.User;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.List;

public class UserForm extends FormLayout {

  private final Grid<User> userGrid;
  private final List<User> userDb;
  BeanValidationBinder<User> binder = new BeanValidationBinder<>(User.class);
  User userEntity = new User();

  TextField firstName = new TextField();
  DatePicker dateOfBirth = new DatePicker();
  EmailField email = new EmailField();
  HorizontalLayout buttonsRow = new HorizontalLayout();
  Button saveNewUser = new Button();
  Button cancelBtn = new Button();

  private void initButtonsRow() {
    buttonsRow.addClassName(Gap.MEDIUM);
    buttonsRow.setWidth("100%");
    saveNewUser.setText("Save new user");
    saveNewUser.setWidth("min-content");
    saveNewUser.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    saveNewUser.addClickListener(event -> saveUser());
    cancelBtn.setText("Cancel");
    cancelBtn.setWidth("min-content");
    buttonsRow.add(saveNewUser);
    buttonsRow.add(cancelBtn);
    add(buttonsRow);
  }

  private void saveUser() {
    userDb.add(userEntity);
    userGrid.setItems(userDb);
    Notification.show("User " + userEntity.getFirstName() + " has been saved");
    userEntity = new User();
    binder.setBean(userEntity);
  }

  private void initFormFields() {
    setWidth("100%");
    firstName.setLabel("First Name");
    dateOfBirth.setLabel("Birthday");
    email.setLabel("Email");
    add(firstName);
    add(dateOfBirth);
    add(email);
  }

  public UserForm(Grid<User> userGrid, List<User> userDb) {
    this.userGrid = userGrid;
    this.userDb = userDb;
    initFormFields();
    initButtonsRow();
    binder.setBean(userEntity);
    binder.bindInstanceFields(this);
  }
}
