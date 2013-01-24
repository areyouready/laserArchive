package de.ayr.laserdb.infrastructure.login.control;

import javax.ejb.Stateless;

@Stateless
//@LocalBean
public class DataStore implements DataStoreLocal {

    public String getData() {
        return "42";
    }
}
