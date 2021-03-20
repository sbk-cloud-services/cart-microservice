package de.leuphana.shop.cartmicroservice.component.behaviour;

import de.leuphana.shop.cartmicroservice.component.structure.Cart;

public interface CartService {
    public Cart createCart();

    public Cart getCart(Integer cartId);

    public void addArticleToCart(Integer articleId, Integer cartId, Integer quantity);

    public void removeArticleFromCart(Integer articleId, Integer cartId);

    public void deleteCart(Integer cartId);
}
