package com.prueba.apiRest.repository;

import com.prueba.apiRest.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IPeopleRepository extends JpaRepository<People,Long> {
    @Query("SELECT p FROM People p WHERE p.documentNumber = :documentNumber AND p.typeDocument = :typeDocument")
    List<People> findPeopleByDocumentNumber(@Param("documentNumber") Long documentNumber,
                                            @Param("typeDocument") String typeDocument);

    @Query("SELECT p FROM People p WHERE p.documentNumber = :documentNumber OR p.typeDocument = :typeDocument")
    List<People> findPeopleByDocumentNumberAngular(@Param("documentNumber") Long documentNumber,
                                                   @Param("typeDocument") String typeDocument);
}
