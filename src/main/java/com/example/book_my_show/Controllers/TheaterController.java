package com.example.book_my_show.Controllers;

import com.example.book_my_show.DTOs.TheaterEntryDto;
import com.example.book_my_show.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity addTheater(@RequestBody TheaterEntryDto theaterEntryDto){
        try{
            String response= theaterService.addTheater(theaterEntryDto);
             return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            String result = "theater not added";

            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
    }
}
