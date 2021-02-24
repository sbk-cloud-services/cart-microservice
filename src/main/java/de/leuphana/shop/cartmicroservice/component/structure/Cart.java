package de.leuphana.shop.cartmicroservice.component.structure;

import java.util.HashSet;
import java.util.Set;

public class Cart {

    private Set<CartItem> cartItems;
    private Integer id;


    public Cart(){
        this.cartItems = new HashSet<CartItem>();

        //TODO: automatically assign ID via connector
    }
    
}
