/*

This is the Car model entity class, which was created from the car table 
contained in our database. It tracks basic car data, including the price of 
a specific car as well as the username of the one who it belongs to.

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
@Table(name = "car")
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findByVin", query = "SELECT c FROM Car c WHERE c.vin = :vin"),
    @NamedQuery(name = "Car.findByMake", query = "SELECT c FROM Car c WHERE c.make = :make"),
    @NamedQuery(name = "Car.findByModel", query = "SELECT c FROM Car c WHERE c.model = :model"),
    @NamedQuery(name = "Car.findByStyle", query = "SELECT c FROM Car c WHERE c.style = :style"),
    @NamedQuery(name = "Car.findBySafteyRating", query = "SELECT c FROM Car c WHERE c.safteyRating = :safteyRating"),
    @NamedQuery(name = "Car.findByYear", query = "SELECT c FROM Car c WHERE c.year = :year"),
    @NamedQuery(name = "Car.findByMiles", query = "SELECT c FROM Car c WHERE c.miles = :miles"),
    @NamedQuery(name = "Car.findBySellerUsername", query = "SELECT c FROM Car c WHERE c.sellerUsername = :sellerUsername")})

public class Car implements Serializable {

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
    
    @Column(name = "miles")
    private Integer miles;
    
    @Column(name = "sellerUsername")
    private String sellerUsername;
    
    @Column(name = "price")
    private Integer price;

    
    // An empty car constructor
    public Car() {
    
    }

    public Car(String vin) {
        this.vin = vin;
    }

    
    
    
    // Get and set the VIN number attribute of a car 
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    // Get and set the make attribute of a car
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    // Get and set the model attribute of a car
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Get and set the style attribute of a car
    // i.e. hatchback, coupe, sedan, convertible, etc.
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    // Get and set the safety rating attribute of a car
    public Short getSafteyRating() {
        return safteyRating;
    }

    public void setSafteyRating(Short safteyRating) {
        this.safteyRating = safteyRating;
    }

    // Get and set the year attribute of a car
    // this is the year a car was produced
    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }
    
    // Get and set the price attribute of a car
    // Also known as list price, this will be user definable
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // Get and set the miles attribute of a car
    // This should be representative of the current mileage of a car
    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    // Get and set the sellerUsername attribute of a car
    // This is the owner of the car and the one who created the car entity
    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    
    // Injected 
    
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
        return "model.Car_1[ vin=" + vin + " ]";
    }



    
}