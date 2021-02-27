package de.leuphana.shop.cartmicroservice.component.behaviour;

import de.leuphana.shop.cartmicroservice.component.structure.Cart;

public interface CartService {

    public Integer createCart();
    public Cart getCart(Integer cartId);
    public Boolean addArticleToCart(Integer articleId);

    
}
