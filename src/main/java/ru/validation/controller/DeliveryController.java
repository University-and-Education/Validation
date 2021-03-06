package ru.validation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.validation.dto.DeliveryRequestDto;
import ru.validation.validation.annotation.ValidParams;

@RestController
public class DeliveryController {

    @ValidParams
    @GetMapping("/check")
    public void checkDeliveryAvailability(@RequestBody DeliveryRequestDto requestDto) {

        System.out.println("Validation!");
    }
}