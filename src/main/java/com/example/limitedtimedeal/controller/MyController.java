package com.example.limitedtimedeal.controller;

import com.example.limitedtimedeal.dto.DealRequest;
import com.example.limitedtimedeal.entity.LimitedTimeDeals;
import com.example.limitedtimedeal.service.LimitedTimeDealService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/limited-time-deals/")
public class MyController {

    private LimitedTimeDealService limitedTimeDealService;

    public MyController(LimitedTimeDealService limitedTimeDealService) {
        this.limitedTimeDealService = limitedTimeDealService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDeal(@RequestBody DealRequest dealRequest){
        //Create a deal with price and number of items to be sold as part of the deal
        limitedTimeDealService.createLimitedTimeDeal(dealRequest);
    }

    @PatchMapping("/end/{dealId}")
    @ResponseStatus(HttpStatus.OK)
    public void endDeal(@PathVariable("id") Long dealId){
        limitedTimeDealService.endDeal(dealId);
    }

    public void updateDeal(){

    }

    public void claimDeal(){

    }
}
