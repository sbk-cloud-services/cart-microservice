package de.leuphana.shop.cartmicroservice.component.behaviour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.cartmicroservice.component.behaviour.exception.CartDoesNotExist;
import de.leuphana.shop.cartmicroservice.component.behaviour.exception.CartIdIsNull;
import de.leuphana.shop.cartmicroservice.component.behaviour.exception.CartIsEmpty;
import de.leuphana.shop.cartmicroservice.component.structure.Cart;

@TestMethodOrder(OrderAnnotation.class)
public class CartServiceTest {
    private static CartService cartService;
    private static ApplicationContext applicationContext;

    @BeforeAll
    public static void BeforeAll() {
        applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        cartService = (CartService) applicationContext.getBean("cartServiceImplementation");
    }

    @Test
    @Order(1)
    public void canCartBeCreated() {
        Assertions.assertNotNull(cartService.createCart());
    }

    @Test
    @Order(2)
    public void canCartBeRetrieved() {
        Cart cart = cartService.createCart();
        Assertions.assertNotNull(cartService.getCart(cart.getId()));
    }

    @Test
    @Order(3)
    public void canArticleBeAddedToCart() {
        Cart cart = cartService.createCart();
        Integer articleId = 1337;
        cartService.addArticleToCart(articleId, cart.getId());
    }

    @Test
    @Order(4)
    public void canArticleBeRemovedFromCart() {
        Cart cart = cartService.createCart();
        Integer articleId = 1337;
        cartService.addArticleToCart(articleId, cart.getId());

        cartService.removeArticleFromCart(articleId, cart.getId());
    }

    @Test
    @Order(5)
    public void canCartBeCheckedOut() {

        Assertions.assertDoesNotThrow(() -> {

            Cart cart = cartService.createCart();
            Integer articleId = 1337;

            cartService.addArticleToCart(articleId, cart.getId());

            cartService.checkoutCart(cart.getId());

        });

        Assertions.assertThrows(CartIsEmpty.class, () -> {
            Cart cart = cartService.createCart();
            cartService.checkoutCart(cart.getId());
        });

        Assertions.assertThrows(CartDoesNotExist.class, () -> {
            cartService.checkoutCart(120000);
        });
        Assertions.assertThrows(CartIdIsNull.class, () -> {
            cartService.checkoutCart(null);
        });

    }

}
