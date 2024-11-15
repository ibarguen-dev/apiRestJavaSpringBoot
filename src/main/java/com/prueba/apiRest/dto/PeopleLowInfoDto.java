package com.prueba.apiRest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleLowInfoDto {
    private Integer idPeople;
    private Integer numberDocumnet;
    private String typeDocument;

    public PeopleLowInfoDto(Integer idPeople,Integer numberDocumnet,String typeDocument){
        this.idPeople = idPeople;
        this.numberDocumnet = numberDocumnet;
        this.typeDocument = typeDocument;
    }
}
