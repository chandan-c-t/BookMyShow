package com.example.book_my_show.DTOs;

import com.example.book_my_show.Enums.Genre;
import com.example.book_my_show.Enums.Language;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntryDto {


    private String movieName;

    private double rating;

    private int duration;


    private Language language;


    private Genre genre;
}
