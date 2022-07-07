package ru.validation.dto;

import lombok.Getter;
import lombok.Setter;
import ru.validation.validation.annotation.NotEmpty;
import ru.validation.validation.annotation.RegExp;

@Getter
@Setter
public class DeliveryRequestDto {

    @NotEmpty
    @RegExp(value = "^[а-яА-ЯёЁ .'-]+$")
    private String region;

    @NotEmpty
    @RegExp(value = "^[а-яА-ЯёЁ .'-]+$")
    private String city;
}