package de.leuphana.shop.cartmicroservice.connector.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="Cart")
public class CartEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(cascade=CascadeType.ALL)
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
