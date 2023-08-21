package nl.framework.applicatie.domein;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150, nullable = false)
    private String naam;
    @Column(length = 150, nullable = false)
    private int leeftijd;
    @Column(length = 150, nullable = false)
    private String email;
    @Column(length = 150, nullable = false)
    private String password;
    @Column(length = 150, nullable = true)
    private String gender;

    @JsonIgnore
    @OneToOne(mappedBy = "account", cascade = { CascadeType.REMOVE, CascadeType.DETACH }, optional = true, orphanRemoval = true)
    private ShoppingCart shoppingCart;

    public String getNaam() {
		return naam;
	}
    
    public void setNaam(String naam) {
		this.naam = naam;
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
    
    public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
    
}