package com.example.book_my_show.Convertors;

import com.example.book_my_show.DTOs.MovieEntryDto;
import com.example.book_my_show.Entities.Movie;

public class MovieConvertor {

    public static Movie convertDtoToEntity(MovieEntryDto movieEntryDto){
        Movie movie = Movie.builder().movieName(movieEntryDto.getMovieName()).duration(movieEntryDto.getDuration())
                .language(movieEntryDto.getLanguage()).genre(movieEntryDto.getGenre()).rating(movieEntryDto.getRating()).build();
        return movie;
    }
}
