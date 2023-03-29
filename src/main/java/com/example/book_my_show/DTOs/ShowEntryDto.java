package com.example.book_my_show.DTOs;

import com.example.book_my_show.Enums.ShowType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowEntryDto {

    private LocalDate showDate;


    private LocalTime showTime;

    private ShowType showType;

    private int movieId;

    private int theaterId;

    private int classicSeatPrice;

    private int premiumSeatPrice;

}
