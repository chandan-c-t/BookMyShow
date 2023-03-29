package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.TheaterConvertor;
import com.example.book_my_show.DTOs.TheaterEntryDto;
import com.example.book_my_show.Entities.Theater;
import com.example.book_my_show.Entities.TheaterSeat;
import com.example.book_my_show.Enums.SeatType;
import com.example.book_my_show.Repositories.TheaterRepository;
import com.example.book_my_show.Repositories.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto) throws  Exception{
        Theater theater = TheaterConvertor.convertDtoToEntity(theaterEntryDto);

        List<TheaterSeat> theaterSeatList = createTheaterSeat(theaterEntryDto,theater);

        theater.setTheaterSeatList(theaterSeatList);

        theaterRepository.save(theater);
        return "theater added";
    }

    private List<TheaterSeat> createTheaterSeat(TheaterEntryDto theaterEntryDto, Theater theater){



        int noClassicSeats = theaterEntryDto.getClassicSeatsCount();
        int noPremiumSeats = theaterEntryDto.getPremiumSeatsCount();

        List<TheaterSeat> list = new ArrayList<>();

        for(int count=1; count<=noClassicSeats; count++){
            TheaterSeat theaterSeat = TheaterSeat.builder().seatType(SeatType.CLASSIC).seatNo(count+"C").theater(theater).build();
            list.add(theaterSeat);
        }

        for(int count = 1; count<= noPremiumSeats; count++){
            TheaterSeat theaterSeat = TheaterSeat.builder().seatType(SeatType.PREMIUM).seatNo(count+"P").theater(theater).build();
            list.add(theaterSeat);
        }
//        theaterSeatRepository.saveAll(list);

        return list;
    }
}
