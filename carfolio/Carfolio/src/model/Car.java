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
@Table(name = "Car")
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findByVin", query = "SELECT c FROM Car c WHERE c.vin = :vin"),
    @NamedQuery(name = "Car.findByMake", query = "SELECT c FROM Car c WHERE c.make = :make"),
    @NamedQuery(name = "Car.findByModel", query = "SELECT c FROM Car c WHERE c.model = :model"),
    @NamedQuery(name = "Car.findByStyle", query = "SELECT c FROM Car c WHERE c.style = :style"),
    @NamedQuery(name = "Car.findBySafteyRating", query = "SELECT c FROM Car c WHERE c.safteyRating = :safteyRating"),
    @NamedQuery(name = "Car.findByYear", query = "SELECT c FROM Car c WHERE c.year = :year")})
public abstract class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vin")
    private String vin;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "style")
    private String style;
    @Column(name = "safteyRating")
    private Short safteyRating;
    @Column(name = "year")
    private Short year;

    public Car() {
    }

    public Car(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Short getSafteyRating() {
        return safteyRating;
    }

    public void setSafteyRating(Short safteyRating) {
        this.safteyRating = safteyRating;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vin != null ? vin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.vin == null && other.vin != null) || (this.vin != null && !this.vin.equals(other.vin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Car[ vin=" + vin + " ]";
    }
    
}
