package de.leuphana.shop.cartmicroservice.component.behaviour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.cartmicroservice.connector.CartDatabaseConnector;

public class CartServiceTest {
    private static CartService cartService;
    private static ApplicationContext applicationContext;

    @BeforeAll
    public static void BeforeAll() {

        applicationContext = new ClassPathXmlApplicationContext("applicationcontext-jpa-connector.xml");
        CartDatabaseConnector cartDatabaseConnector = (CartDatabaseConnector) applicationContext.getBean("cartDatabaseConnector");

        cartService = CartServiceImplementation.getInstance();
        ((CartServiceImplementation)cartService).setCartDatabaseConnector(cartDatabaseConnector);

    }

    @Test
    public void canCartBeCreated() {

        Assertions.assertNotNull(cartService.createCart());

    }

    @Test
    public void canCartBeRetrieved() {
        int cartId = cartService.createCart();
        Assertions.assertNotNull(cartService.getCart(cartId));

    }

    @Test
    public void canArticleBeAdded2Cart() {

        int articleId = 1;
        int cartId = 1;
        Assertions.assertTrue(cartService.addArticleToCart(articleId, cartId));

    }

}
