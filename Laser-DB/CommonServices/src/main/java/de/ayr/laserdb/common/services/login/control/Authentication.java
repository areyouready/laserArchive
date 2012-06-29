package de.ayr.laserdb.common.services.login.control;

import de.ayr.laserdb.common.services.login.entity.User;

public class Authentication {

    public Authentication() {

    }
    
    public User Authenticate(String Username, String Password) {
        
        User user = new User("Demo", "User");
        return user;
                       
    }

}
