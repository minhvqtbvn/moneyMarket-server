package com.moneyMarket.controller;

import com.moneyMarket.entity.JsonResponse;
import com.moneyMarket.entity.Market;
import com.moneyMarket.service.Market.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/market")
public class MarketController {
    @Autowired
    MarketService marketService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> markets() {
        try {
            List<Market> markets = marketService.marketList();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_OK)
                    .setMessage("get success!")
                    .setMetaData(markets), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> store(@RequestBody Market market) {
        try {
            if (market == null)
                return new ResponseEntity<>(new JsonResponse()
                        .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                        .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_CREATED)
                    .setMessage("Create success!")
                    .setMetaData(marketService.store(market)), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
