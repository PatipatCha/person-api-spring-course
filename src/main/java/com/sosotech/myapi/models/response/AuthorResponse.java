package com.sosotech.myapi.models.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorResponse {

    private String authorId;
    private String authorName;
    private String authorStatus;

    public AuthorResponse(String authorId, String authorName,String authorStatus) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorStatus = authorStatus;
    }
}
