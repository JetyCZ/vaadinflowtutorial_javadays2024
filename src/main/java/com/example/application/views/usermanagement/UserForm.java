package com.example.application.views.usermanagement;

import com.example.application.data.User;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

public class UserForm extends FormLayout {

  BeanValidationBinder<User> binder = new BeanValidationBinder<>(User.class);

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
    saveNewUser.addClickListener(e -> saveUser());
    cancelBtn.setText("Cancel");
    cancelBtn.setWidth("min-content");
    buttonsRow.add(saveNewUser);
    buttonsRow.add(cancelBtn);
    add(buttonsRow);
  }

  public static class SaveUserEvent extends ComponentEvent<UserForm> {
    private final User user;
    public SaveUserEvent(UserForm source, User user) {
      super(source, false);
      this.user = user;
    }
    public User getUser() {
      return user;
    }
  }

  private void saveUser() {
    fireEvent(new SaveUserEvent(this, binder.getBean()));
    Notification.show("User " + binder.getBean().getFirstName() + " has been saved");
  }

  public void addSaveListener(ComponentEventListener<SaveUserEvent> listener) {
    addListener(SaveUserEvent.class, listener);
  }

  public void setUser(User user) {
    binder.setBean(user);
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

  public UserForm() {
    initFormFields();
    initButtonsRow();
    binder.setBean(new User());
    binder.bindInstanceFields(this);
  }
}
