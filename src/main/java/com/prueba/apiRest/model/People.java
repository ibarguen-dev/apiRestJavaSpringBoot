package com.prueba.apiRest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people")
public class People {
    @Id
    @Column(name="idPeople")
    private Long idPeople;

    @Column(name="firstName")
    private String firstName;
    @Column(name="middleName")
    private String middleName;
    @Column(name="firstSurname")
    private String firstSurname;
    @Column(name="secondSurname")
    private String secondSurname;
    @Column(name="typeDocument")
    private String typeDocument;
    @Column(name="documentNumber")
    private Integer documentNumber;
    @Column(name="phone")
    private String phone;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
}
