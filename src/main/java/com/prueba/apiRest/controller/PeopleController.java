package com.prueba.apiRest.controller;

import com.prueba.apiRest.dto.PeopleAllInfoDto;
import com.prueba.apiRest.dto.PeopleLowInfoDto;
import com.prueba.apiRest.dto.PeopleQueryDto;
import com.prueba.apiRest.model.People;
import com.prueba.apiRest.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/Peoples")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;



    @PostMapping("/")
    public ResponseEntity<?> findPeopleByDocumentNumber(@RequestBody(required = true) PeopleQueryDto people ){
        try{
            if(!Objects.equals(people.getTypeDocument(), "C") &&
                    !Objects.equals(people.getTypeDocument(), "P")){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El Tipo de documento no es valido");
            }

            if(people.getDocumentNumber() != 10121314L){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El numero de documento no es valido");
            }
            List<PeopleAllInfoDto> response = peopleService.findPeopleByDocumentNumber(people.getDocumentNumber(),
                    people.getTypeDocument());
            if(response.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El numero de documento no existe");
            }
            return  ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error en el sistema");
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllPeople( ){
        try{
            List<PeopleAllInfoDto> response = peopleService.getAllPeoples();
            return  ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error en el sistema");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPeopleByDocmunet(@RequestParam (required = false)  Long number,
                                                    @RequestParam (required = false)  String type){
        try{
            List<PeopleAllInfoDto> response = peopleService.findPeopleByDocumentNumberAngular(number,
                    type);
            return  ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error en el sistema");
        }
    }


    @PostMapping("/save")
    public ResponseEntity<?> savePeople(@RequestBody(required = true) People people ){
        try{
            People response = peopleService.savePeople(people);
            return  ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error en el sistema");
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> savePeople(){
        try{
            peopleService.DeletePeople();
            return  ResponseEntity.noContent().build();
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error en el sistema");
        }
    }
}
