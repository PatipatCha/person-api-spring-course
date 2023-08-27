package com.sosotech.myapi.repository;

import com.sosotech.myapi.models.entity.AuthorEntity;
import com.sosotech.myapi.models.response.AuthorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {

//    List<AuthorResponse> findByAuthorId(String authorId);

//    @Query(value = "select * from authors where author_id=:author_id", nativeQuery = true)
//    public List<AuthorEntity> getAuthorAll(Long id);

}
