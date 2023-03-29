package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.ShowConvertor;
import com.example.book_my_show.DTOs.ShowEntryDto;
import com.example.book_my_show.Entities.*;
import com.example.book_my_show.Enums.SeatType;
import com.example.book_my_show.Repositories.MovieRepository;
import com.example.book_my_show.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {



    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public String addShow(ShowEntryDto showEntryDto) throws  Exception{
        Show show = ShowConvertor.convertEntityToDto(showEntryDto);


        Movie movie = movieRepository.findById(showEntryDto.getMovieId()).get();

        Theater theater = theaterRepository.findById(showEntryDto.getTheaterId()).get();

        show.setMovie(movie);
        show.setTheater(theater);

        List<ShowSeats> showSeatsList = createShowSeatList(showEntryDto,show);

        show.setSeatsList(showSeatsList);

        List<Show> shows = movie.getShowList();
        shows.add(show);
        movie.setShowList(shows);

        movieRepository.save(movie);

        List<Show> shows1 = theater.getShowList();
        shows1.add(show);
        theater.setShowList(shows1);

        theaterRepository.save(theater);

        return "show added";

    }

    private List<ShowSeats> createShowSeatList(ShowEntryDto showEntryDto, Show show){

        Theater theater = show.getTheater();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeats> showSeatsList = new ArrayList<>();

        for(TheaterSeat seat : theaterSeatList){
            ShowSeats showSeats = new ShowSeats();

            showSeats.setSeatNo(seat.getSeatNo());
            showSeats.setSeatType(seat.getSeatType());

            if(seat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeats.setPrice(showEntryDto.getClassicSeatPrice());
            } else{
                showSeats.setPrice(showEntryDto.getPremiumSeatPrice());
            }

            showSeats.setBooked(false);
            showSeats.setShow(show);

            showSeatsList.add(showSeats);
        }

        return showSeatsList;
    }
}
