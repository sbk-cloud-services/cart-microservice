package de.leuphana.shop.cartmicroservice.component.structure;

import de.leuphana.shop.articlemicroservice.component.structure.Article;

public class CartItem {

    private Integer quantity;
    private Article article;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    

}
