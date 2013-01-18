package de.ayr.laserdb.common.services.login.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import com.google.inject.ImplementedBy;

import de.ayr.laserdb.common.services.login.entity.User;

@SessionScoped
@ImplementedBy(AuthenticationImpl.class)
public interface Authentication extends Serializable {

    public User Authenticate(String Username, String Password);

}
