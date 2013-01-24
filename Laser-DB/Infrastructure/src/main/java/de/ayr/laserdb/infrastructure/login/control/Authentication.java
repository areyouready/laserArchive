package de.ayr.laserdb.infrastructure.login.control;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.ayr.laserdb.infrastructure.entity.User;

//@SessionScoped
@Stateless
public class Authentication implements Serializable {

    private DataStoreLocal dataStoreLocal;
//    @EJB
//    private DataStore dataStore;
    
    @Inject
    public Authentication(DataStoreLocal dataStoreLocal) {
        this.dataStoreLocal = dataStoreLocal;
    }
    
    protected Authentication() {
        
    }
    
    public User Authenticate(String Username, String Password) {
        
        System.out.println(dataStoreLocal.getData());
        
        User user = new User("Demo", "User");
        return user;
                       
    }
    
    

}
