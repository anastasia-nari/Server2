package com.example.server.response;

import com.example.server.entity.AuthorEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorListResponse extends BaseResponse {
    public AuthorListResponse(Iterable<AuthorEntity> data){
        super(true, "Авторы");
        this.data=data;
    }
    private Iterable<AuthorEntity> data;
}
