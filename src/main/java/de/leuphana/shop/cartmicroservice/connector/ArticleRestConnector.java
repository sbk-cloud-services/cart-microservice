package de.leuphana.shop.cartmicroservice.connector;

import org.springframework.cloud.openfeign.FeignClient;

import de.leuphana.shop.articlemicroservice.component.structure.Article;
import feign.Param;
import feign.RequestLine;


@FeignClient(name = "article", url = "http://article:8080")
public interface ArticleRestConnector {
    @RequestLine("GET /articles/{id}")
    Article contributors(@Param("id") Integer id);
}
