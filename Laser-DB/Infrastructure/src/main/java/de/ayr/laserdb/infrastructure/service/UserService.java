package de.ayr.laserdb.infrastructure.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.ayr.laserdb.infrastructure.entity.User;

@Stateless
public class UserService implements Serializable {

    @PersistenceContext
    EntityManager em;
    
    public UserService() {
        
    }
    
    public void createNewUser() {
        User testUser = new User("Tester", "TestPW");
        em.persist(testUser);
    }
    
}
