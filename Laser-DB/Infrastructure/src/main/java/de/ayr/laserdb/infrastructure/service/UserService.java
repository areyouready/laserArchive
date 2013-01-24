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
        adminUser.setPassword(Util.createPasswordHash("MD5", Util.BASE64_ENCODING, null, null, "admin_user_secret"));
//        adminUser.setPassword("admin_user_secret");
        em.persist(adminUser);
        
        User testUser = new User();
        testUser.setUsername("test.user");
//        testUser.setPassword("test_user_secret");
        testUser.setPassword(Util.createPasswordHash("MD5", Util.BASE64_ENCODING, null, null, "test_user_secret"));
        em.persist(testUser);

        List<UserRole> userRoles = new ArrayList<UserRole> ();
        // admin role 
        UserRole adminRole = new UserRole();
        adminRole.setUser(adminUser);
        adminRole.setRole("admin");
        userRoles.add(adminRole);
        em.persist(adminRole);
        
        // management role
        UserRole mgmtRole = new UserRole();
        mgmtRole.setUser(adminUser);
        mgmtRole.setRole("mgmt");
        userRoles.add(mgmtRole);
        em.persist(mgmtRole);
        
        // Test Role
        UserRole tstRole = new UserRole();
        tstRole.setUser(testUser);
        tstRole.setRole("mgmt");
        userRoles.add(tstRole);
        em.persist(tstRole);
        // create user
//        user.setUserRoles(userRoles);
//        userService.createUser(user);
        
    }
    
}
