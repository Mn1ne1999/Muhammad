package org.example.lession13.repository;


import org.example.lession13.model.Person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT DISTINCT p FROM Person p LEFT JOIN p.addresses a " +
            "WHERE (:region IS NULL OR a.region = :region) AND p.active = true")
    Page<Person> findPage(@Param("region") String region, Pageable pageable);

    @Query("SELECT CASE WHEN count(p)>0 THEN true ELSE false END FROM Person p " +
            "JOIN p.identityDocuments d " +
            "WHERE concat(p.lastName,' ',p.firstName,' ',p.middleName)=:name " +
            "AND d.type='PASSPORT' AND d.number=:passport")
    boolean verifyNameAndPassport(@Param("name") String name, @Param("passport") String passport);
}
