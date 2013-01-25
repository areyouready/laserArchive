package de.ayr.laserdb.infrastructure.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.security.auth.spi.Util;

import de.ayr.laserdb.infrastructure.entity.User;
import de.ayr.laserdb.infrastructure.entity.UserRole;

@Stateless
public class UserService implements Serializable {

    @PersistenceContext
    EntityManager em;
    
    public UserService() {
        
    }
    
    public void createNewUser() {
//        User testUser = new User("Tester", "TestPW");
        
        User adminUser = new User();
        adminUser.setUsername("admin.user");
        adminUser.setPassword(Util.createPasswordHash("SHA-256", Util.BASE64_ENCODING, null, null, "admin"));
        em.persist(adminUser);
        
        User testUser = new User();
        testUser.setUsername("test.user");
        testUser.setPassword(Util.createPasswordHash("SHA-256", Util.BASE64_ENCODING, null, null, "test"));
        em.persist(testUser);

        User mgmtUser = new User();
        mgmtUser.setUsername("mgmt.user");
        mgmtUser.setPassword(Util.createPasswordHash("SHA-256", Util.BASE64_ENCODING, null, null, "mgmt"));
        em.persist(mgmtUser);

        
        List<UserRole> userRoles = new ArrayList<UserRole> ();
        // admin role 
        UserRole adminRole = new UserRole();
        adminRole.setUser(adminUser);
        adminRole.setRole("admin");
        userRoles.add(adminRole);
        em.persist(adminRole);
        
        // management role
        UserRole mgmtRole = new UserRole();
        mgmtRole.setUser(mgmtUser);
        mgmtRole.setRole("mgmt");
        userRoles.add(mgmtRole);
        em.persist(mgmtRole);
        
        // Test Role
        UserRole tstRole = new UserRole();
        tstRole.setUser(testUser);
        tstRole.setRole("test");
        userRoles.add(tstRole);
        em.persist(tstRole);
        // create user
//        user.setUserRoles(userRoles);
//        userService.createUser(user);
        
    }
    
}
