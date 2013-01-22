package de.ayr.laserdb.common.services.login.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import de.ayr.laserdb.common.services.login.entity.User;

@SessionScoped
public interface Authentication extends Serializable {

    public User Authenticate(String Username, String Password);

}
