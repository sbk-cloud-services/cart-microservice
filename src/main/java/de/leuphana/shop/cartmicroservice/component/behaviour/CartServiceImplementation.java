package de.leuphana.shop.cartmicroservice.component.behaviour;

import de.leuphana.shop.cartmicroservice.component.structure.Cart;
import de.leuphana.shop.cartmicroservice.connector.CartDatabaseConnector;

public class CartServiceImplementation implements CartService {

    private static CartService cartServiceImplementation;
    private CartDatabaseConnector cartDatabaseConnector;

    public static CartService getInstance() {
        if (cartServiceImplementation == null)
            cartServiceImplementation = new CartServiceImplementation();
        return cartServiceImplementation;
    }

    public void setCartDatabaseConnector(CartDatabaseConnector cartDatabaseConnector) {
        this.cartDatabaseConnector = cartDatabaseConnector;
    }

    @Override
    public Cart createCart() {

        Cart cart = new Cart();
        cart.setId(cartDatabaseConnector.createCart(cart));

        return cart;
    }

    @Override
    public Cart getCart(Integer cartId) {

        Cart retrievedCart = cartDatabaseConnector.getCart(cartId);

        return retrievedCart;
    }

    @Override
    public Boolean addArticleToCart(Integer articleId, Integer cartId) {

        boolean isAdded = true;
        return isAdded;
    }

}
