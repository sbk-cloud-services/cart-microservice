package de.leuphana.shop.cartmicroservice.connector.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "CartItem")
public class CartItemEntity {
    @Id @GeneratedValue
    private Integer id;
    private Integer quantity;
    private Integer articleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticle(Integer articleId) {
        this.articleId = articleId;
    }
}
