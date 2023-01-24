package com.example.currencyexchange.controllers;

import com.example.currencyexchange.Beans.CurrencyExchange;
import com.example.currencyexchange.services.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ExchangeController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;
    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchange(@PathVariable String from, @PathVariable String to){

        CurrencyExchange currencyExchange = currencyExchangeService.retrieveCurrencyFromTo(from, to);
        String port = environment.getProperty("server.port");
        if(currencyExchange == null)
            throw new RuntimeException("The currencies with this records are empty");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }

    @GetMapping("/currency-exchange")
    public List<CurrencyExchange> retrieveAll(){

        return currencyExchangeService.retrieveAllCurrencies();
    }
}
