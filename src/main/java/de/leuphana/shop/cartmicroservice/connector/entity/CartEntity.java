package de.leuphana.shop.cartmicroservice.connector.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import de.leuphana.shop.cartmicroservice.component.structure.CartItem;


@Entity(name="Cart")
public class CartEntity {

    @Id @GeneratedValue
    private Integer id;
    
    @Embedded
    private Set<CartItem> cartItems;

    public CartEntity(){
        this.cartItems = new HashSet<CartItem>();
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    
    
}
