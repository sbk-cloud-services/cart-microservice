package de.leuphana.shop.cartmicroservice.connector.mapper;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import de.leuphana.shop.cartmicroservice.component.structure.Cart;
import de.leuphana.shop.cartmicroservice.connector.entity.CartEntity;

public class CartMapper {


    private static Mapper mapper;

    static {
        mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    public static CartEntity mapCartToCartEntity(Cart cart) {
        return mapper.map(cart, CartEntity.class);
    }

    public static Cart mapCartEntityToCart(CartEntity cartEntity) {
        return mapper.map(cartEntity, Cart.class);
    }
    
}
