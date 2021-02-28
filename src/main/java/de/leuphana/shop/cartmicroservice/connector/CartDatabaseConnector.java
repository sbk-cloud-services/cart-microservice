package de.leuphana.shop.cartmicroservice.connector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import de.leuphana.shop.cartmicroservice.component.structure.Cart;
import de.leuphana.shop.cartmicroservice.connector.entity.CartEntity;
import de.leuphana.shop.cartmicroservice.connector.mapper.CartMapper;

public class CartDatabaseConnector {

    private EntityManager entityManager;

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Integer createCart(Cart cart) {
        CartEntity cartEntity = CartMapper.mapCartToCartEntity(cart);
        entityManager.persist(cartEntity);

        return cartEntity.getId();

    }

    @Transactional
    public Cart getCart(Integer cartId) {

        CartEntity cartEntity = entityManager.getReference(CartEntity.class, cartId);

        return CartMapper.mapCartEntityToCart(cartEntity);

    }

    @Transactional
    public Boolean addArticleToCart(Integer articleId, Integer cartId){

        //TODO: Implement method addArticleToCart

        return true;
    }

}