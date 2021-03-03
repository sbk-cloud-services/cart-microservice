package de.leuphana.shop.cartmicroservice.connector.mapper;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import de.leuphana.shop.cartmicroservice.component.structure.CartItem;
import de.leuphana.shop.cartmicroservice.connector.entity.CartItemEntity;

public class CartItemMapper {

    private static Mapper mapper;

    static {
        mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    public static CartItemEntity mapCartItemToCartItemEntity(CartItem cartItem) {
        return mapper.map(cartItem, CartItemEntity.class);
    }

    public static CartItem mapCartItemEntityToCartItem(CartItemEntity cartItemEntity) {
        return mapper.map(cartItemEntity, CartItem.class);
    }
    
}
