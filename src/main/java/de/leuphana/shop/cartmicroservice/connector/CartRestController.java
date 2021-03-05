package de.leuphana.shop.cartmicroservice.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.leuphana.shop.cartmicroservice.component.behaviour.CartService;
import de.leuphana.shop.cartmicroservice.component.structure.Cart;

@RestController
public class CartRestController {

    @Autowired
    ApplicationContext applicationContext;

    @PostMapping("/carts")
    @ResponseBody
    public Cart createCart(){
        CartService cartService = (CartService) applicationContext.getBean("cartServiceImplementation");

        return cartService.createCart();


    }

    @GetMapping("/carts/{id}")
    @ResponseBody
    public Cart getCart(@PathVariable("id") Integer cartId){
        CartService cartService = (CartService) applicationContext.getBean("cartServiceImplementation");

        return cartService.getCart(cartId);
    }

    
    @PostMapping("/carts/{id}/{article}")
    @ResponseBody
    public void addArticleToCart(@PathVariable("id") Integer cartId, @PathVariable("article") Integer articleId){

        CartService cartService = (CartService) applicationContext.getBean("cartServiceImplementation");
        cartService.addArticleToCart(articleId, cartId);

    }
    
}
