package de.leuphana.shop.cartmicroservice.connector;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.leuphana.shop.cartmicroservice.component.behaviour.CartService;
import de.leuphana.shop.cartmicroservice.component.structure.Cart;

@RestController
public class CartRestController {

    @PostMapping("/carts")
    @ResponseBody
    public Cart createCart() {
        CartService cartService = (CartService) CartServiceApplication.getApplicationContext()
                .getBean("cartServiceImplementation");
        return cartService.createCart();

    }

    @GetMapping("/carts/{id}")
    @ResponseBody
    public Cart getCart(@PathVariable("id") Integer cartId) {
        CartService cartService = (CartService) CartServiceApplication.getApplicationContext()
                .getBean("cartServiceImplementation");

        return cartService.getCart(cartId);
    }

    @PostMapping("/carts/{id}/{article}")
    @ResponseBody
    public void addArticleToCart(@PathVariable("id") Integer cartId, @PathVariable("article") Integer articleId) {

        CartService cartService = (CartService) CartServiceApplication.getApplicationContext()
                .getBean("cartServiceImplementation");
        cartService.addArticleToCart(articleId, cartId);

    }

    @DeleteMapping("/carts/{id}/{article}")
    @ResponseBody
    public void removeArticleFromCart(@PathVariable("id") Integer cartId, @PathVariable("article") Integer articleId) {
        CartService cartService = (CartService) CartServiceApplication.getApplicationContext()
                .getBean("cartServiceImplementation");
        cartService.removeArticleFromCart(articleId, cartId);
    }

    @DeleteMapping("/carts/{id}")
    @ResponseBody
    public void checkoutCart(@PathVariable("id") Integer cartId) {
        CartService cartService = (CartService) CartServiceApplication.getApplicationContext()
                .getBean("cartServiceImplementation");

        cartService.checkoutCart(cartId);

    }

}
