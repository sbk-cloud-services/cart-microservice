package de.leuphana.shop.cartmicroservice.connector.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="Cart")
public class CartEntity {

    @Id @GeneratedValue
    private Integer id;
    
    private List<CartItemEntity> cartItems;

    public CartEntity() {
        this.cartItems = new ArrayList<CartItemEntity>();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CartItemEntity> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemEntity> cartItems) {
        this.cartItems = cartItems;
    }

}
