package de.leuphana.shop.cartmicroservice.component.behaviour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CartServiceTest {
    private static CartService cartService;


    @BeforeAll
    public static void BeforeAll(){

        cartService = new CartServiceImplementation();
        
    }




    @Test
    public void canCartBeCreated(){

        Assertions.assertNotNull(cartService.createCart());


    }
    @Test
    public void canCartBeRetrieved(){
        int cartId = cartService.createCart();
        Assertions.assertNotNull(cartService.getCart(cartId));

    }
    @Test
    public void canArticleBeAdded2Cart(){

        int articleId = 1;
        int cartId = 1;
        Assertions.assertTrue(cartService.addArticleToCart(articleId, cartId));

    }

}
