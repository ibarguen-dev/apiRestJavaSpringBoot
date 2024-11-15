package com.prueba.apiRest.service;

import com.prueba.apiRest.dto.PeopleAllInfoDto;
import com.prueba.apiRest.dto.PeopleLowInfoDto;
import com.prueba.apiRest.dto.PeopleQueryDto;
import com.prueba.apiRest.dto.PeopleSaveDto;
import com.prueba.apiRest.model.People;
import com.prueba.apiRest.repository.IPeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeopleService {
    private final IPeopleRepository peopleRepository;

    @Autowired
    public PeopleService(IPeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    public List<PeopleAllInfoDto> getAllPeoples(){
        List<People> peoples = (List<People>) peopleRepository.findAll();

        return peoples.stream().map(p -> new PeopleAllInfoDto(p.getIdPeople(),p.getFirstName(),p.getMiddleName(),
                p.getFirstSurname(),p.getSecondSurname(),p.getTypeDocument(),p.getDocumentNumber(),p.getPhone()
                ,p.getAddress(),p.getAddress())).collect(Collectors.toList());
    }

    public List<PeopleAllInfoDto> findPeopleByDocumentNumber(Long documentNamber, String typeDocument){
        List<People> people =  peopleRepository.findPeopleByDocumentNumber( documentNamber,typeDocument);

        return people.stream().map(p -> new PeopleAllInfoDto(p.getIdPeople(),p.getFirstName(),p.getMiddleName(),
                p.getFirstSurname(),p.getSecondSurname(),p.getTypeDocument(),p.getDocumentNumber(),p.getPhone()
        ,p.getAddress(),p.getAddress())).collect(Collectors.toList());
    }

    public List<PeopleAllInfoDto> findPeopleByDocumentNumberAngular(Long documentNamber, String typeDocument){
        List<People> people =  peopleRepository.findPeopleByDocumentNumberAngular( documentNamber,typeDocument);

        return people.stream().map(p -> new PeopleAllInfoDto(p.getIdPeople(),p.getFirstName(),p.getMiddleName(),
                p.getFirstSurname(),p.getSecondSurname(),p.getTypeDocument(),p.getDocumentNumber(),p.getPhone()
                ,p.getAddress(),p.getAddress())).collect(Collectors.toList());
    }

    public People  savePeople(People people ){
        return peopleRepository.save(people);
    }

    public Boolean  DeletePeople(){
         peopleRepository.deleteAll();
        return true;
    }
}
