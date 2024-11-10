package com.example.application.views.usermanagement;

import com.example.application.data.User;
import com.example.application.service.UserService;
import com.example.application.views.usermanagement.UserForm.SaveUserEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
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
    TextField filterText = new TextField();


    public UserView(UserService userService) {
        this.userService = userService;
        setWidth("100%");
        setMaxWidth("800px");
        setHeight("min-content");

        initUserGrid();
        filterText.setWidth("400px");
        filterText.setPlaceholder("Filter by First name or E-mail...");
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> filterUsersInGrid());

        add(filterText);
        add(userGrid);

        h3.setText("Add new user");
        h3.setWidth("100%");
        add(h3);
        add(userForm);
        userForm.addSaveListener(this::saveUser);
    }

    private void filterUsersInGrid() {
        userGrid.setItems(
            userService.searchUsers(filterText.getValue())
        );
    }

    private void saveUser(SaveUserEvent saveUserEvent) {
        userService.addUser(saveUserEvent.getUser());
        userForm.setUser(new User());
        reloadUserGrid();
    }

    private void initUserGrid() {
        userGrid.removeAllColumns();
        userGrid.addColumn("firstName").setHeader("First name");
        userGrid.addColumn("email").setHeader("E-mail");

        userGrid.addColumn(new LocalDateRenderer<>(
                User::getDateOfBirth,
                () -> DateTimeFormatter.ofPattern("d.M. yyyy")))
            .setHeader("Date of birth");

        userGrid.addComponentColumn(user -> {
            Button deleteButton = new Button(new Icon(VaadinIcon.TRASH));
            deleteButton.addClickListener(event -> {
                deleteUser(user);
            });
            return deleteButton;
        }).setHeader("Actions");
        reloadUserGrid();
    }

    private void deleteUser(User user) {
        userService.delete(user);
        reloadUserGrid();
        Notification.show("User " + user.getFirstName() + " has been deleted...");
    }

    private void reloadUserGrid() {
        userGrid.setItems(userService.findAllUsers());
    }


}
