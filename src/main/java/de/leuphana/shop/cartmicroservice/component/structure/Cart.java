package de.leuphana.shop.cartmicroservice.component.structure;

import java.util.HashSet;
import java.util.Set;

public class Cart {

    private Set<CartItem> cartItems;
    private Integer id;


    public Cart(){
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
