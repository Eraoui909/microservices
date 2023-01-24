package com.example.currencyexchange.services;

import com.example.currencyexchange.Beans.CurrencyExchange;
import com.example.currencyexchange.repositories.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchange retrieveCurrencyFromTo(String from, String to){
        return currencyExchangeRepository.findByFromAndTo(from.toUpperCase(),to.toUpperCase());
    }



    public List<CurrencyExchange> retrieveAllCurrencies(){

        return currencyExchangeRepository.findAll();
    }
}
