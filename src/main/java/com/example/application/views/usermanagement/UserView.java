package com.example.application.views.usermanagement;

import com.example.application.User;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("User management")
@Route("")
@Menu(order = 1, icon = "line-awesome/svg/user.svg")
public class UserView extends VerticalLayout {

    H3 h3 = new H3();
    FormLayout form = new FormLayout();
    TextField firstName = new TextField();
    DatePicker dateOfBirth = new DatePicker();
    EmailField email = new EmailField();
    HorizontalLayout buttonsRow = new HorizontalLayout();
    Button registerNewAccountBtn = new Button();
    Button cancelBtn = new Button();

    Grid<User> userGrid = new Grid<>(User.class);

    public UserView() {
        setWidth("100%");
        setMaxWidth("800px");
        setHeight("min-content");

        initUserGrid();
        add(userGrid);

        initUserForm();
        add(form);

        initButtonsRow();
        add(buttonsRow);

    }

    private void initUserGrid() {
        userGrid.removeAllColumns();
        userGrid.addColumn("firstName").setHeader("First name");
        userGrid.addColumn("email").setHeader("E-mail");
        userGrid.addColumn("dateOfBirth").setHeader("Birthday");
    }

    private void initButtonsRow() {
        buttonsRow.addClassName(Gap.MEDIUM);
        buttonsRow.setWidth("100%");
        registerNewAccountBtn.setText("Register new account");
        registerNewAccountBtn.setWidth("min-content");
        registerNewAccountBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        registerNewAccountBtn.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                Notification.show("User " + firstName.getValue() + " has been registered");
            }
        });
        cancelBtn.setText("Cancel");
        cancelBtn.setWidth("min-content");
        buttonsRow.add(registerNewAccountBtn);
        buttonsRow.add(cancelBtn);
    }

    private void initUserForm() {
        h3.setText("Add new user");
        h3.setWidth("100%");
        add(h3);
        form.setWidth("100%");
        firstName.setLabel("First Name");
        dateOfBirth.setLabel("Birthday");
        email.setLabel("Email");
        form.add(firstName);
        form.add(dateOfBirth);
        form.add(email);
    }


}
