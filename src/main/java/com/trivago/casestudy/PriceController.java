package com.trivago.casestudy;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/prices/{accommodationId}")
    public Accommodation getPrices(@PathVariable Integer accommodationId) {
        if(accommodationId < 0)
            throw new IllegalArgumentException("The ID of Accommodation cannot be negative value");
        return priceService.getPrices(accommodationId);
    }
}
