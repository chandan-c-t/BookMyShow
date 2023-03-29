package com.example.book_my_show.Convertors;

import com.example.book_my_show.DTOs.ShowEntryDto;
import com.example.book_my_show.Entities.Show;

public class ShowConvertor {

    public static Show convertEntityToDto(ShowEntryDto showEntryDto){
        Show show = Show.builder().showDate(showEntryDto.getShowDate()).showTime(showEntryDto.getShowTime()).showType(showEntryDto.getShowType()).build();

        return show;
    }
}
