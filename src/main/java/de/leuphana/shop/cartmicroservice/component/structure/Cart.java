package de.leuphana.shop.cartmicroservice.component.structure;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems;
    private Integer id;


    public Cart(){
        this.cartItems = new ArrayList<CartItem>();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

}
