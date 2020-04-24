/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Dstet
 */
@Entity
@Table(name = "Buyer")
@NamedQueries({
    @NamedQuery(name = "Buyer.findAll", query = "SELECT b FROM Buyer b"),
    @NamedQuery(name = "Buyer.findByFirstName", query = "SELECT b FROM Buyer b WHERE b.firstName = :firstName"),
    @NamedQuery(name = "Buyer.findByLastName", query = "SELECT b FROM Buyer b WHERE b.lastName = :lastName"),
    @NamedQuery(name = "Buyer.findByUserName", query = "SELECT b FROM Buyer b WHERE b.userName = :userName"),
    @NamedQuery(name = "Buyer.findByPassword", query = "SELECT b FROM Buyer b WHERE b.password = :password"),
    @NamedQuery(name = "Buyer.findByBuyerRating", query = "SELECT b FROM Buyer b WHERE b.buyerRating = :buyerRating")})
public class Buyer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Id
    @Basic(optional = false)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "buyerRating")
    private Double buyerRating;

    public Buyer() {
    }

    public Buyer(String userName) {
        this.userName = userName;
    }

    public Buyer(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBuyerRating() {
        return buyerRating;
    }

    public void setBuyerRating(Double buyerRating) {
        this.buyerRating = buyerRating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buyer)) {
            return false;
        }
        Buyer other = (Buyer) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Buyer[ userName=" + userName + " ]";
    }
    
}
