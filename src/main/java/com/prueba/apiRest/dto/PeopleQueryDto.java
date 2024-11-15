package com.prueba.apiRest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleQueryDto {
    private Long documentNumber;
    private String typeDocument;
}
