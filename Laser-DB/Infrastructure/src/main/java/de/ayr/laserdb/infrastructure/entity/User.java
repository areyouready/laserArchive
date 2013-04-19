package de.ayr.laserdb.infrastructure.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = User.FETCH_ALL_USER, query = "SELECT a FROM User a ORDER BY a.username ASC")})
public class User extends BaseEntity {
    
    public static final String Prefix = "de.ayr.laserdb.infrastructure.entity.User";
    public static final String FETCH_ALL_USER = Prefix + ".fetchAllUser";
    
    private String username;
    private String password;
  
    @OneToMany(orphanRemoval = true, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "user")
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    private List<UserRole> userRoles;
    
    public User(String username, String password) {
        
        this.username = username;
        this.password = password;
        
    }
    
    public User() {
        
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setUserRoles(List<UserRole> userRoles) {
         this.userRoles = userRoles;
        
    }
    
    public List<UserRole> getUserRoles() {
        return userRoles;
       
   }
}
