package de.leuphana.shop.cartmicroservice.component.behaviour;

public interface CartService {

    public Integer createCart();
    public Cart getCart(Integer cartId);
    public Boolean addArticle2Cart(Integer articleId);

    
}
