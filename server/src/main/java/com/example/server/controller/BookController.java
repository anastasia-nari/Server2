
package com.example.server.controller;

import com.example.server.entity.BookEntity;
import com.example.server.exception.ValidationExceptionBook;
import com.example.server.response.BaseResponse;
import com.example.server.response.BookListResponse;
import com.example.server.servise.BookService;
import com.example.server.utils.BookValidationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private  final BookService service;
    public BookController(BookService service){this.service=service;}

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody BookEntity data){
        try {
            BookValidationUtils.bookValidationUtils(data);
            service.save(data).getId();
            return ResponseEntity.ok(new BaseResponse(true, "Книга добавлена"));
        } catch (ValidationExceptionBook e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }



@PutMapping("/update")
public ResponseEntity<BaseResponse> update(@RequestBody BookEntity data){
    try{
        BookValidationUtils.bookValidationUtils(data);
        service.save(data);
        return ResponseEntity.ok(new BaseResponse(true, "В книгу добавлены изменения"));
    } catch (ValidationExceptionBook e){
        return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
    }
    catch (Exception e){
        return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
    }
}

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id){
        try{
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "удалена"));
        } catch (Exception e){
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }

    @GetMapping("/search")
    public ResponseEntity<BaseResponse> getBook(@RequestParam String title){
        return ResponseEntity.ok(new BookListResponse(service.getTitle(title)));
    }

}


