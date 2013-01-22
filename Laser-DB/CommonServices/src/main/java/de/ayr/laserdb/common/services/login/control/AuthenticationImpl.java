package de.ayr.laserdb.common.services.login.control;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.ayr.laserdb.common.services.login.entity.User;

//@SessionScoped
@Stateless
public class AuthenticationImpl implements Authentication {

//    @EJB
    @Inject
    private DataStoreLocal dataStoreLocal;
//    @EJB
//    private DataStore dataStore;
    
    public AuthenticationImpl() {
        
    }
    
    public User Authenticate(String Username, String Password) {
        
        System.out.println(dataStoreLocal.getData());
        
        User user = new User("Demo", "User");
        return user;
                       
    }
    
    

}
