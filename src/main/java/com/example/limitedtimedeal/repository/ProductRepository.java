package com.example.limitedtimedeal.repository;

import com.example.limitedtimedeal.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class ProductRepository {
    private Logger logger = LoggerFactory.getLogger(ProductRepository.class);
    private EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Product findProductById(Long id){
        return Optional.ofNullable(entityManager.find(Product.class,id)).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND)
        );
    }
}
