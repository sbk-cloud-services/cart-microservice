package de.leuphana.shop.cartmicroservice.component.behaviour;

import org.springframework.beans.factory.annotation.Autowired;

import de.leuphana.shop.cartmicroservice.component.structure.Cart;
import de.leuphana.shop.cartmicroservice.connector.ArticleRestConnector;
import de.leuphana.shop.cartmicroservice.connector.CartDatabaseConnector;

public class CartServiceImplementation implements CartService {

    private CartDatabaseConnector cartDatabaseConnector;

    @Autowired
    private ArticleRestConnector articleRestConnector;

    public CartServiceImplementation(CartDatabaseConnector cartDatabaseConnector) {
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
