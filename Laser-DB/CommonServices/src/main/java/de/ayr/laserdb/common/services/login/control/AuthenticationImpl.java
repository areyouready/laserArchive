package de.ayr.laserdb.common.services.login.control;

import javax.enterprise.context.SessionScoped;

import de.ayr.laserdb.common.services.login.entity.User;

@SessionScoped
public class AuthenticationImpl implements Authentication {

    public AuthenticationImpl() {

    }
    
    public User Authenticate(String Username, String Password) {
        
        User user = new User("Demo", "User");
        return user;
                       
    }

}
