package de.leuphana.shop.cartmicroservice.component.behaviour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CartServiceTest {
    private static CartService cartService;
    private static ApplicationContext applicationContext;

    @BeforeAll
    public static void BeforeAll() {

        applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");

        cartService = (CartService) applicationContext.getBean("cartServiceImplementation");

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
