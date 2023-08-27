package com.sosotech.myapi.controllers;


import com.sosotech.myapi.models.entity.AuthorEntity;
import com.sosotech.myapi.models.entity.PersonalEntity;
import com.sosotech.myapi.models.request.AuthorRequest;
import com.sosotech.myapi.models.request.PersonalRequest;
import com.sosotech.myapi.services.AuthorService;
import com.sosotech.myapi.services.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/personal")
@RequiredArgsConstructor
public class PersonalController {
    private final PersonalService personalService;

    @GetMapping(path = "")
    public ResponseEntity<?> getPerson() {
        List<PersonalEntity> list = personalService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<?> getPerson(@PathVariable("id") int id) {
        PersonalEntity person = personalService.findById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> createPersonal(@RequestBody PersonalRequest personalRequest) {

        PersonalEntity personalEntity = new PersonalEntity();
        personalEntity.setFirstname(personalRequest.getFirstname());
        personalEntity.setLastname(personalRequest.getLastname());
        personalEntity.setMobile(personalRequest.getMobile());

        try {
            personalService.save(personalEntity);
            return new ResponseEntity<>(personalEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
