package com.example.server.controller;



import com.example.server.entity.PublisherEntity;
import com.example.server.exception.ValidationExceptionPublisher;
import com.example.server.response.BaseResponse;
import com.example.server.servise.PublisherService;
import com.example.server.utils.PublisherValidationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherController {
    private  final PublisherService service;
    public PublisherController(PublisherService service){this.service=service;}
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody PublisherEntity data){
        try {
            PublisherValidationUtils.validationPublisher(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Издательство добавлено"));
        } catch (ValidationExceptionPublisher e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}

