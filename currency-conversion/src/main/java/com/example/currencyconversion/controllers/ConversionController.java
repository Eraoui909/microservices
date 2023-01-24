package com.example.currencyconversion.controllers;

import com.example.currencyconversion.beans.CurrencyConversion;
import com.example.currencyconversion.proxies.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convert(@PathVariable String from, @PathVariable String to, @PathVariable String quantity){

        CurrencyConversion conversion = new CurrencyConversion();

        Map<String, String> params = new HashMap<>();
        params.put("from", from);
        params.put("to", to);
        ResponseEntity<CurrencyConversion> resp = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class, params);
        conversion = resp.getBody();
        conversion.setQuantity(new BigDecimal(quantity));
        conversion.setTotalCalculatedAmount(conversion.getQuantity().multiply(conversion.getConversionMultiple()));
        //new CurrencyConversion(1001L, "usd", "mad", new BigDecimal(22), new BigDecimal("10.2"), BigDecimal.valueOf(22 * 10.2), "")
        return conversion;
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertFeign(@PathVariable String from, @PathVariable String to, @PathVariable String quantity){

        CurrencyConversion conversion = new CurrencyConversion();

        conversion = currencyExchangeProxy.retrieveExchangeValue(from, to);
        conversion.setQuantity(new BigDecimal(quantity));
        conversion.setTotalCalculatedAmount(conversion.getQuantity().multiply(conversion.getConversionMultiple()));
        conversion.setEnvironment(conversion.getEnvironment()+" Feign" );
        //new CurrencyConversion(1001L, "usd", "mad", new BigDecimal(22), new BigDecimal("10.2"), BigDecimal.valueOf(22 * 10.2), "")
        return conversion;
    }

}
