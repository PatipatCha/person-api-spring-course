package com.sosotech.myapi.services;

import com.sosotech.myapi.models.entity.AuthorEntity;
import com.sosotech.myapi.models.entity.PersonalEntity;
import com.sosotech.myapi.models.request.PersonalRequest;
import com.sosotech.myapi.models.response.PersonalResponse;
import com.sosotech.myapi.repository.AuthorRepository;
import com.sosotech.myapi.repository.PersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalService {

    private final PersonalRepository personalRepository;

    public List<PersonalEntity> findAll() {
        return  personalRepository.findAll();
    }

    public PersonalEntity findById(int id) {
        return  personalRepository.findById(id);
    }

    public void save(PersonalEntity personalEntity){
        PersonalEntity personal = new PersonalEntity();
        personal.setFirstname(personalEntity.getFirstname());
        personal.setLastname(personalEntity.getLastname());
        personalRepository.save(personal);
    }

    public void update(PersonalRequest personalRequest){

    }





}
