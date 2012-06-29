package de.ayr.laserdb.common.services.login.entity;

import javax.persistence.Entity;

@Entity
public class User {
    
    private String vorname;
    private String nachname;
    
    public User(String vorname, String nachname) {
        
        this.vorname = vorname;
        this.nachname = nachname;
        
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    
}
