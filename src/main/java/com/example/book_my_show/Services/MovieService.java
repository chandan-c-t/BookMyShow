package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.MovieConvertor;
import com.example.book_my_show.DTOs.MovieEntryDto;
import com.example.book_my_show.Entities.Movie;
import com.example.book_my_show.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public String addMovie(MovieEntryDto movieEntryDto) throws Exception{

        Movie movie = MovieConvertor.convertDtoToEntity(movieEntryDto);
        movieRepository.save(movie);

        return "movie added";
    }
}
