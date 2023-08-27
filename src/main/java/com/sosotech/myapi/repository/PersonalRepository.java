package com.sosotech.myapi.repository;


import com.sosotech.myapi.models.entity.PersonalEntity;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalRepository extends JpaRepository<PersonalEntity,Long>, CrudRepository<PersonalEntity,Long> {
//    @Query("SELECT p FROM Personal p WHERE p.id = ?1")
//    PersonalEntity findPersonalById(int id);

    PersonalEntity findById(int id);


//    @Modifying
//    @Transactional
//    @Query("UPDATE Personal p set firstname =?1 lastname =?2 mobile =?3 where p.id = ?4")
//    void update(String firstname,String lastname,String mobile,int id);
}
