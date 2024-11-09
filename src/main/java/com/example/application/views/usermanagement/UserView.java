package com.example.application.views.usermanagement;

import com.example.application.User;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.LocalDateTimeRenderer;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@PageTitle("User management")
@Route("")
@Menu(order = 1, icon = "line-awesome/svg/user.svg")
public class UserView extends VerticalLayout {

    List<User> userDb = new ArrayList<>();
    Grid<User> userGrid = new Grid<>(User.class);
    H3 h3 = new H3();
    UserForm userForm = new UserForm();

    public UserView() {
        setWidth("100%");
        setMaxWidth("800px");
        setHeight("min-content");

        initUserGrid();
        add(userGrid);

        h3.setText("Add new user");
        h3.setWidth("100%");
        add(h3);
        add(userForm);
    }

    private void initUserGrid() {
        userGrid.removeAllColumns();
        userGrid.addColumn("firstName").setHeader("First name");
        userGrid.addColumn("email").setHeader("E-mail");

        userGrid.addColumn(new LocalDateTimeRenderer<>(
                User::getDateOfBirth,
                () -> DateTimeFormatter.ofPattern("d.M. yyyy")))
            .setHeader("Date of birth");

        userDb.add(new User("Pavel", LocalDateTime.now(), "pavel@seznam.cz"));
        userDb.add(new User("Jan", LocalDateTime.now(), "jan@seznam.cz"));

        userGrid.setItems(userDb);
    }



}
