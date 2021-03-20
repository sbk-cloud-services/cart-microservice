package de.leuphana.shop.cartmicroservice.component.behaviour;

import java.util.Optional;

import org.dozer.MappingException;

import de.leuphana.shop.cartmicroservice.component.behaviour.exception.CartDoesNotExist;
import de.leuphana.shop.cartmicroservice.component.behaviour.exception.CartIdIsNull;
import de.leuphana.shop.cartmicroservice.component.behaviour.exception.CartIsEmpty;
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
    public void addArticleToCart(Integer articleId, Integer cartId, Integer quantity) {

        Cart cart = this.getCart(cartId);

        CartItem cartItem = getCartItemByArticleId(articleId, cart);

        if (cartItem != null) {
            cartItem.setQuantity(quantity);
        } else {
            cartItem = new CartItem();
            cartItem.setArticleId(articleId);
            cartItem.setQuantity(quantity);
            cartItem = cartDatabaseConnector.createCartItem(cartItem);

            cart.getCartItems().add(cartItem);
        }

        cartDatabaseConnector.updateCart(cart);
    }

    @Override
    public void removeArticleFromCart(Integer articleId, Integer cartId) {

        Cart cart = this.getCart(cartId);

        CartItem cartItem = getCartItemByArticleId(articleId, cart);

        if (cartItem != null) {
            cart.getCartItems().remove(cartItem);
        }

        cartDatabaseConnector.updateCart(cart);

    }

    @Override
    public void checkoutCart(Integer cartId) {
        if (cartId != null) {

            Cart cart = retrieveCartFromEntityManager(cartId);

            if (!cart.getCartItems().isEmpty()) {

                cartDatabaseConnector.deleteCart(cartId);

            } else {
                throw new CartIsEmpty();
            }

        } else {
            throw new CartIdIsNull();
        }

    }

    private Cart retrieveCartFromEntityManager(Integer cartId) {
        try {
            Cart cart = cartDatabaseConnector.getCart(cartId);

            return cart;

        } catch (MappingException e) {

            throw new CartDoesNotExist();

        }
    }

    private CartItem getCartItemByArticleId(Integer articleId, Cart cart) {
        Optional<CartItem> cartItemOptional = cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getArticleId() == articleId).findFirst();
        return cartItemOptional.isPresent() ? cartItemOptional.get() : null;
    }

}
