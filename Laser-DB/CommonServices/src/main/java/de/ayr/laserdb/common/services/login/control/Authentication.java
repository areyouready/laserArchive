package de.ayr.laserdb.common.services.login.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.ayr.laserdb.common.services.login.entity.User;

@Named
@SessionScoped
public class Authentication implements Serializable {

    public Authentication() {

    }
    
    public User Authenticate(String Username, String Password) {
        
        User user = new User("Demo", "User");
        return user;
                       
    }

}
