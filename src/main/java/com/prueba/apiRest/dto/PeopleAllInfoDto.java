package com.prueba.apiRest.dto;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleAllInfoDto {

    private Long idPeople;

    private String firstName;

    private String middleName;

    private String firstSurname;

    private String secondSurname;

    private String typeDocument;

    private Integer documentNumber;

    private String phone;

    private String address;

    private String city;

    public PeopleAllInfoDto(Long idPeople,String firstName,String middleName,String firstSurname,
                            String secondSurname, String typeDocument,Integer documentNumber,String phone,String
                                    address,String city){
         this.idPeople = idPeople;
         this.firstName = firstName;
         this.middleName = middleName;
         this.firstSurname = firstSurname;
         this.secondSurname = secondSurname;
         this.typeDocument = typeDocument;
         this.documentNumber = documentNumber;
         this.phone = phone;
         this.address = address;
         this.city= city;

    }
}
