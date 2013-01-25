package de.ayr.laserdb.infrastructure.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = User.FETCH_ALL_USER, query = "SELECT a FROM User a ORDER BY a.username ASC")})
public class User {
    
    public static final String Prefix = "de.ayr.laserdb.infrastructure.entity.User";
    public static final String FETCH_ALL_USER = Prefix + ".fetchAllUser";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String password;
  
    @OneToMany(mappedBy = "user")
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
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserRoles(List<UserRole> userRoles) {
         this.userRoles = userRoles;
        
    }
}
