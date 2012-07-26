package de.ayr.laserdb.main.controller;

import javax.inject.Inject;
import javax.inject.Named;

import de.ayr.laserdb.application.LaserWeb;
import de.ayr.laserdb.common.services.login.control.Authentication;
import de.ayr.laserdb.common.services.login.entity.User;

@Named
public class LoginHandler {

    private Authentication auth = new Authentication();
    
    private static final long serialVersionUID = 2126197548761564883L;

//    @Inject
//    private Authentication auth2;
    
    private String loginField;
    private String pwdField;
    private User user;

    public LoginHandler() {
        
        //System.out.println(auth2);
        
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
            
            // Da getApplication nur aus einer Vaadin KOmponent heraus funktioniert wird dies durch die statische
            // ThreadLocal VAriable LaserWeb umgangen. Bei getApplication müsste diese Klasse von einem Vaadin
            // Element wie Panel oder CustomComponent extenden
            LaserWeb.getProject().getMainWindow().showNotification("Login Failed, try using demo / demo");
            //getApplication().getMainWindow().showNotification("Login Failed, try using demo / demo");

        }

    }

}
