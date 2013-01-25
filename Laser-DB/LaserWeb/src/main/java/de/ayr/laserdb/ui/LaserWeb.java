package de.ayr.laserdb.ui;

import java.io.Serializable;

import javax.inject.Inject;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.cdi.Root;
import com.vaadin.cdi.VaadinUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import de.ayr.laserdb.infrastructure.service.UserService;
import de.ayr.laserdb.main.controller.MainController;
import de.ayr.laserdb.main.view.LoginView;

@Theme("lasertheme")
@Title("LaserDisc Database")
@PreserveOnRefresh
@Root
@VaadinUI
public class LaserWeb extends UI implements Serializable {

    private LoginView loginView;
    
    private UserService userService;

    @Inject
    public LaserWeb(MainController mainController, LoginView loginView /*, UserService userService*/ ) {
        this.loginView = loginView;
//        this.userService = userService;
    }
    
    @Override
    protected void init(VaadinRequest request) {
        setSizeFull();
//        userService.createNewUser();
        setContent(loginView);
        
    }


}
