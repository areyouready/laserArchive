package de.ayr.laserdb.infrastructure.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String role;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    public UserRole(String role, User user) {
        
        this.role = role;
        this.user = user;
        
    }
    
    public UserRole() {
        
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getRole() {
        return role;
    }
    
    public User getUser() {
        return user;
    }
    
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
