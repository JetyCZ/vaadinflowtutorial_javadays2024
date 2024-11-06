package com.example.application.views.newuseraccountregistration;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("New user account registration")
@Route("person-form")
@Menu(order = 1, icon = "line-awesome/svg/user.svg")
public class NewuseraccountregistrationView extends Composite<VerticalLayout> {

    VerticalLayout layoutColumn2 = new VerticalLayout();
    H3 h3 = new H3();
    FormLayout formLayout2Col = new FormLayout();
    TextField firstName = new TextField();
    TextField textField2 = new TextField();
    DatePicker datePicker = new DatePicker();
    TextField textField3 = new TextField();
    EmailField emailField = new EmailField();
    HorizontalLayout layoutRow = new HorizontalLayout();
    Button registerNewAccountBtn = new Button();
    Button buttonSecondary = new Button();


    public NewuseraccountregistrationView() {

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        layoutColumn2.setWidth("100%");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("min-content");
        h3.setText("Please provide your credentials");
        h3.setWidth("100%");
        formLayout2Col.setWidth("100%");
        firstName.setLabel("First Name");
        textField2.setLabel("Last Name");
        datePicker.setLabel("Birthday");
        textField3.setLabel("Phone Number");
        textField3.setPlaceholder("777123456");
        emailField.setLabel("Email");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        registerNewAccountBtn.setText("Register new account");
        registerNewAccountBtn.setWidth("min-content");
        registerNewAccountBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        registerNewAccountBtn.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                Notification.show("User " + firstName.getValue() + " has been registered");
            }
        });
        buttonSecondary.setText("Cancel");
        buttonSecondary.setWidth("min-content");
        getContent().add(layoutColumn2);
        layoutColumn2.add(h3);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(firstName);
        formLayout2Col.add(textField2);
        formLayout2Col.add(datePicker);
        formLayout2Col.add(textField3);
        formLayout2Col.add(emailField);
        layoutColumn2.add(layoutRow);
        layoutRow.add(registerNewAccountBtn);
        layoutRow.add(buttonSecondary);
    }



}
