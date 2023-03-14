
package com.example.server.controller;

import com.example.server.entity.AuthorEntity;
import com.example.server.exception.ValidationExceptionAuthor;
import com.example.server.response.BaseResponse;
import com.example.server.servise.AuthorService;
import com.example.server.utils.AuthorValidationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private final AuthorService service;
    public AuthorController(AuthorService service){this.service=service;}
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody AuthorEntity data){
        try {
            AuthorValidationUtils.authorValidationUtils(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Автор добавлен"));
        } catch (ValidationExceptionAuthor e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}
