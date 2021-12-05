package com.example.limitedtimedeal.repository;

import com.example.limitedtimedeal.dto.DealRequest;
import com.example.limitedtimedeal.entity.LimitedTimeDeals;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class LimitedTimeDealRepository {

    private EntityManager entityManager;

    public LimitedTimeDealRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void saveDeal(LimitedTimeDeals limitedTimeDeal){
        entityManager.persist(limitedTimeDeal);
    }

    public LimitedTimeDeals findById(Long dealId){
        return Optional.ofNullable(entityManager.find(LimitedTimeDeals.class,dealId)).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
}
