package com.example.book_my_show.Convertors;

import com.example.book_my_show.DTOs.TheaterEntryDto;
import com.example.book_my_show.Entities.Theater;

public class TheaterConvertor {

    public static Theater convertDtoToEntity(TheaterEntryDto theaterEntryDto){
        Theater theater = Theater.builder().name(theaterEntryDto.getName()).location(theaterEntryDto.getLocation()).build();
        return theater;
    }
}
