/*
    This is the User model entity class, which was created from the User table
    contained in our database. It takes in all basic user data, including the
    (first and last) name of the user, their username, password, what type of 
    user they are (Buyer, Seller, Admin) and what their userRating is.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByUserType", query = "SELECT u FROM User u WHERE u.userType = :userType"),
    @NamedQuery(name = "User.findByUserRating", query = "SELECT u FROM User u WHERE u.userRating = :userRating")})

public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "userType")
    private Short userType;
    
    @Column(name = "userRating")
    private Short userRating;

 
    // A User Constructor contatining all possible attribures of a User
    public User(String username, String password, String firstName, String lastName, Short userType, Short userRating) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
        this.userRating = userRating;
    }
    
    // The User constructor that is used for logging into account
    // This will be passed from the loginController to whichever UI corresponds
    // with that particular user's accountType
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // The User constructor that is used for registering an account
    public User(String username, String password, String firstName, String lastName, Short userType) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }

    // An empty User constructor
    public User() {
    
    }

   

    
    // Get and set the username attribute of a user
    // This name is displayed on the home page when a user logs in
    // Also used for the act of logginf in itself
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    // Get and set the password attribute of a user
    // Used for logging in a particular user
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //  Get and set the first and last name attributes of a user
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    // Get and set the userType attribute of a user
    public Short getUserType() {
        return userType;
    }

    /* 
    setUserType takes in a string corresponding with a user type,
    such as an admin, seller or buyer. While buyer and seller are the only
    two strings actively used in registration, there is one administrator 
    account that was created directly through connection to the database.
    */
    public void setUserType(String type) {
        switch(type) {
            case ("admin"): 
                this.userType = 0;
                break;
            case ("seller"):
                this.userType = 1;
                break;
            case ("buyer"):
                this.userType = 2;
                break;
            
        }
    }
    
    // Get and set the userRating attribute of a user
    // While laregely unused (for now), this would control the ammount of stars
    // on a user's account and be visible when a portfolio is selected
    public Short getUserRating() {
        return userRating;
    }

    public void setUserRating(Short userRating) {
        this.userRating = userRating;
    }

    // Injected
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{ " + this.firstName + " " + this.lastName + " has Username " + this.username + " with account type of " + this.userType + " }";
    }



    
    
    
    
}
