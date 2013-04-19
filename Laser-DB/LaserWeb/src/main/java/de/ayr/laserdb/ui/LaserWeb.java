package de.ayr.laserdb.ui;

import java.io.Serializable;

import javax.inject.Inject;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import de.ayr.laserdb.infrastructure.boundary.UserService;
import de.ayr.laserdb.main.login.LoginView;

@Theme("lasertheme")
@Title("LaserDisc Database")
@PreserveOnRefresh
// Ohne Value = Root, alle anderen CDIUIs bekommen Namen via (value = "SecondUI")
@CDIUI
public class LaserWeb extends UI implements Serializable {

    private LoginView loginView;
    
    private UserService userService;

    @Inject
    public LaserWeb(LoginView loginView , UserService userService ) {
        this.loginView = loginView;
        this.userService = userService;
    }
    
    @Override
    protected void init(VaadinRequest request) {
        setSizeFull();
//        userService.createNewUser();
        userService.createInitialUsers();
        setContent(loginView);
        
    }


}
