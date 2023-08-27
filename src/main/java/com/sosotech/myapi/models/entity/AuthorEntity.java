package com.sosotech.myapi.models.entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="author_id")
    private String author_id;

    @Column(name="author_name")
    private String author_name;

}














//    public Author(Long id, String author_id, String author_name) {
//
//        this.id = id;
//        this.author_id = author_id;
//        this.author_name = author_name;
//    }