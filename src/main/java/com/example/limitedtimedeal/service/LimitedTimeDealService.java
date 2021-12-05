package com.example.limitedtimedeal.service;

import com.example.limitedtimedeal.dto.DealRequest;
import com.example.limitedtimedeal.entity.LimitedTimeDeals;
import com.example.limitedtimedeal.entity.Product;
import com.example.limitedtimedeal.repository.LimitedTimeDealRepository;
import com.example.limitedtimedeal.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LimitedTimeDealService {

    private LimitedTimeDealRepository limitedTimeDealRepository;
    private ProductRepository productRepository;

    public LimitedTimeDealService(LimitedTimeDealRepository limitedTimeDealRepository, ProductRepository productRepository) {
        this.limitedTimeDealRepository = limitedTimeDealRepository;
        this.productRepository = productRepository;
    }

    public void createLimitedTimeDeal(DealRequest dealRequest){
        Product product = productRepository.findProductById(dealRequest.getProduct_id());
        if(dealRequest.getQuantity()>product.getUnits())
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Invalid Quantity Specified");
        LimitedTimeDeals limitedTimeDeals = new LimitedTimeDeals();//unique deals
        limitedTimeDeals.setProduct(product);
        limitedTimeDeals.setDealPrice(limitedTimeDeals.getDealPrice());
        limitedTimeDeals.setMaxUnits(dealRequest.getQuantity());
        limitedTimeDeals.setDealStart(LocalDateTime.parse(dealRequest.getStartTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        limitedTimeDeals.setDealEnd(LocalDateTime.parse(dealRequest.getEndTime(),DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        limitedTimeDealRepository.saveDeal(limitedTimeDeals);
    }

    public void endDeal(Long dealId){
        LimitedTimeDeals limitedTimeDeals = limitedTimeDealRepository.findById(dealId);
        limitedTimeDeals.setDealEnd(LocalDateTime.now());//checking cur time
        limitedTimeDealRepository.saveDeal(limitedTimeDeals);
    }

}
