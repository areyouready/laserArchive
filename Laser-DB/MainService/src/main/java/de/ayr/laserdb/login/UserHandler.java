package de.ayr.laserdb.login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import de.ayr.laserdb.infrastructure.entity.User;

@SessionScoped
public class UserHandler implements Serializable{
    private User loggedInUser;

    public UserHandler() {
    }

    public void setUser(User user) {
        this.loggedInUser = user;
    }

    public User getUser() {
        return loggedInUser;
    }

}
