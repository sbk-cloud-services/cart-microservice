package de.leuphana.shop.cartmicroservice.component.behaviour;

import de.leuphana.shop.cartmicroservice.component.structure.Cart;

public class CartServiceImplementation implements CartService {

    @Override
    public Integer createCart() {
        


        int cartId = 0;

        return cartId;
    }

    @Override
    public Cart getCart(Integer cartId) {
        
        Cart retrievedCart = new Cart();


        return retrievedCart;
    }

    @Override
    public Boolean addArticle2Cart(Integer articleId) {
        

        boolean isAdded = true;
        return isAdded;
    }

}
