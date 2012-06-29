package de.ayr.laserdb.main.controller;

import com.vaadin.ui.Panel;

import de.ayr.laserdb.application.LaserWeb;
import de.ayr.laserdb.common.services.login.control.Authentication;
import de.ayr.laserdb.common.services.login.entity.User;

public class LoginHandler extends Panel {

    private Authentication auth = new Authentication();

    private String loginField;
    private String pwdField;
    private User user;

    public LoginHandler() {

    }

    public void doLogin(String loginField, String pwdField) {

        this.loginField = loginField;
        this.pwdField = pwdField;

        user = auth.Authenticate(loginField, pwdField);

        if (user != null) {

            // Sets the application user and sends out an event to inform that
            // the user has logged in. UiHandler will receive this event.
            LaserWeb.getProject().setUser((Object) user.getVorname() + " " + user.getNachname());

            
        } else {

            getApplication().getMainWindow().showNotification("Login Failed, try using demo / demo");

        }

    }

}
