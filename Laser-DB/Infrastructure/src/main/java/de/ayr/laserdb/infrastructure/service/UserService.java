package de.ayr.laserdb.infrastructure.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.security.auth.spi.Util;

import de.ayr.laserdb.infrastructure.entity.User;
import de.ayr.laserdb.infrastructure.entity.UserRole;

@Stateless
public class UserService implements Serializable {

    @PersistenceContext
    EntityManager em;
    
    public UserService() {
        
    }
    
    public void createInitialUsers() {
        
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

        
//        List<UserRole> userRoles = new ArrayList<UserRole> ();
        // admin role 
        UserRole adminRole = new UserRole();
        adminRole.setUser(adminUser);
        adminRole.setRole("admin");
        em.persist(adminRole);
        
        // management role
        UserRole mgmtRole = new UserRole();
        mgmtRole.setUser(mgmtUser);
        mgmtRole.setRole("mgmt");
        em.persist(mgmtRole);
        
        // Test Role
        UserRole tstRole = new UserRole();
        tstRole.setUser(testUser);
        tstRole.setRole("test");
        em.persist(tstRole);

        // create user
//        userRoles.add(adminRole);
//        userRoles.add(mgmtRole);
//        userRoles.add(tstRole);
//        user.setUserRoles(userRoles);
//        userService.createUser(user);
        
    }

    public void createNewUser(String username, String password, String group) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(Util.createPasswordHash("SHA-256", Util.BASE64_ENCODING, null, null, password));
        em.persist(user);
        
        UserRole role = new UserRole();
        role.setUser(user);
        role.setRole(group);
        em.persist(role);
    }

    public List<User> getUser() {
        Query query = em.createNamedQuery(User.FETCH_ALL_USER);
        return query.getResultList();
    }
    
}
