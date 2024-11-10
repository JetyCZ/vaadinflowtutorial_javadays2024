package com.example.application.views.usermanagement;

import com.example.application.data.User;
import com.example.application.service.UserService;
import com.example.application.views.usermanagement.UserForm.SaveUserEvent;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("User management")
@Route("")
@Menu(order = 1, icon = "line-awesome/svg/user.svg")
public class UserView extends VerticalLayout {

    UserService userService;

    Grid<User> userGrid = new Grid<>(User.class);
    H3 h3 = new H3();
    UserForm userForm = new UserForm();

    public UserView(UserService userService) {
        this.userService = userService;
        setWidth("100%");
        setMaxWidth("800px");
        setHeight("min-content");

        initUserGrid();
        add(userGrid);

        h3.setText("Add new user");
        h3.setWidth("100%");
        add(h3);
        add(userForm);
        userForm.addSaveListener(this::saveUser);
    }

    private void saveUser(SaveUserEvent saveUserEvent) {
        userService.addUser(saveUserEvent.getUser());
        userForm.setUser(new User());
        userGrid.setItems(userService.findAllUsers());
    }

    private void initUserGrid() {
        userGrid.removeAllColumns();
        userGrid.addColumn("firstName").setHeader("First name");
        userGrid.addColumn("email").setHeader("E-mail");

        userGrid.addColumn(new LocalDateRenderer<>(
                User::getDateOfBirth,
                () -> DateTimeFormatter.ofPattern("d.M. yyyy")))
            .setHeader("Date of birth");

        userGrid.setItems(userService.findAllUsers());
    }



}
