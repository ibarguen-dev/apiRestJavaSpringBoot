package com.prueba.apiRest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleSaveDto {
    private Integer idPeople;

    private String firstName;

    private String middleName;

    private String firstSurname;

    private String secondSurname;

    private String typeDocument;

    private Integer documentNumber;

    private String phone;

    private String address;

    private String city;
}
