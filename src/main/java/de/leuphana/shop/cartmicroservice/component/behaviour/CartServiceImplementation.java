package de.leuphana.shop.cartmicroservice.component.behaviour;

import java.util.Optional;

import de.leuphana.shop.cartmicroservice.component.structure.Cart;
import de.leuphana.shop.cartmicroservice.component.structure.CartItem;
import de.leuphana.shop.cartmicroservice.connector.CartDatabaseConnector;

public class CartServiceImplementation implements CartService {

    private CartDatabaseConnector cartDatabaseConnector;

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
        return cartDatabaseConnector.getCart(cartId);
    }

    @Override
    public void addArticleToCart(Integer articleId, Integer cartId) {

        Cart cart = this.getCart(cartId);

        Optional<CartItem> cartItemOptional = cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getArticleId() == articleId).findFirst();

        CartItem cartItem;

        if (cartItemOptional.isPresent()) {
            cartItem = cartItemOptional.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            cartItem = new CartItem();
            cartItem.setArticleId(articleId);
            cartItem.setQuantity(1);
            cartItem = cartDatabaseConnector.createCartItem(cartItem);

            cart.getCartItems().add(cartItem);
        }

        cartDatabaseConnector.updateCart(cart);
    }

    @Override
    public void removeArticleFromCart(Integer articleId, Integer cartId) {

        Cart cart = this.getCart(cartId);

        Optional<CartItem> cartItemOptional = cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getArticleId() == articleId).findFirst();

        CartItem cartItem;

        if (cartItemOptional.isPresent()) {
            cartItem = cartItemOptional.get();

            if (cartItem.getQuantity() == 1) {
                cart.getCartItems().remove(cartItem);

            } else if (cartItem.getQuantity() > 1) {
                cartItem.setQuantity(cartItem.getQuantity() - 1);
            }

        }
        cartDatabaseConnector.updateCart(cart);

    }

}
