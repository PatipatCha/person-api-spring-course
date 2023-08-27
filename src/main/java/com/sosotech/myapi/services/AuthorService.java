package com.sosotech.myapi.services;

import com.sosotech.myapi.models.entity.AuthorEntity;
import com.sosotech.myapi.models.request.AuthorRequest;
import com.sosotech.myapi.models.response.AuthorResponse;
import com.sosotech.myapi.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {


    private final AuthorRepository authorRepository;

    public List<AuthorEntity> findAuthors() {
        return  authorRepository.findAll();
    }

    public AuthorEntity  addOne(AuthorEntity authorEntity) {

        AuthorEntity au = new AuthorEntity();

        String author_id = authorEntity.getAuthor_id();
        String author_name = authorEntity.getAuthor_name();

        au.setAuthor_id(author_id);
        au.setAuthor_name(author_name);

        authorRepository.save(au);

        return au;
    }

    public List<AuthorEntity> addAll(List<AuthorRequest> authorRequestLists) {

        List<AuthorEntity> auLists = authorRequestLists.stream().map(data ->{
            AuthorEntity authorEntity = new AuthorEntity();
            authorEntity.setAuthor_id(data.getAuthorId());
            authorEntity.setAuthor_name(data.getAuthorName());
            return authorEntity;
        }).toList();

        authorRepository.saveAll(auLists);

        return auLists;


    }




}




