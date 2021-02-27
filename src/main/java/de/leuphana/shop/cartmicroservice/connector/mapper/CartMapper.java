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

    public static CartEntity mapCartToCartEntity(Cart customer) {
        return mapper.map(customer, CartEntity.class);
    }

    public static Cart mapCustomerEntityToCustomer(CartEntity cartEntity) {
        return mapper.map(cartEntity, Cart.class);
    }
    
}
