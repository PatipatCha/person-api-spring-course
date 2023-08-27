package com.sosotech.myapi.controllers;

import com.sosotech.myapi.models.dao.AuthorDao;
import com.sosotech.myapi.models.entity.AuthorEntity;
import com.sosotech.myapi.models.request.AuthorRequest;
import com.sosotech.myapi.models.response.AuthorResponse;
import com.sosotech.myapi.services.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/author")
@RequiredArgsConstructor
public class AuthorController {

    // @Autowired
    private final AuthorService authorService;

    @GetMapping(path = "")
    public ResponseEntity<?> getAuthor() {
        List<AuthorEntity> list = authorService.findAuthors();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(path = "/addAuthor")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorRequest authorRequest) {

        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setAuthor_id(authorRequest.getAuthorId());
        authorEntity.setAuthor_name(authorRequest.getAuthorName());
        try {
            authorEntity = authorService.addOne(authorEntity);
            return new ResponseEntity<>(authorEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(path = "/addAuthors")
    public ResponseEntity<?> createAuthors(@RequestBody List<AuthorRequest> authorRequestLists) {

        try {
            AuthorEntity au =   (AuthorEntity) authorService.addAll(authorRequestLists);
            return new ResponseEntity<>(au, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(path = "/updateAuthor/{authorId}")
    public ResponseEntity<?> updateAuthor(@RequestBody String authorId) {
        return new ResponseEntity<>(authorId, HttpStatus.OK);
    }

}

// @PostMapping (path="/updateAuthor/{authorId}")
// public ResponseEntity<?> updateAuthor(@RequestBody String authorId){
//
// return new ResponseEntity<>(authorId,HttpStatus.OK);
// }

// @GetMapping("/")
// public List<Author> getAuthor(){
// var au = authorService.findAuthors();
// return au;
//
// }

// @PostMapping(path="" )
// public ResponseEntity<?> getAuthorByName(@RequestBody AuthorRequest
// authorRequest){
// AuthorResponse au = new
// AuthorResponse(authorRequest.getAuthorId(),authorRequest.getAuthorName(),"Active");
// return new ResponseEntity<>(au,HttpStatus.OK);
// }
