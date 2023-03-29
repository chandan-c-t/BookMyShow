package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.TicketConvertor;
import com.example.book_my_show.DTOs.BookTicketEntryDto;
import com.example.book_my_show.Entities.Show;
import com.example.book_my_show.Entities.ShowSeats;
import com.example.book_my_show.Entities.Ticket;
import com.example.book_my_show.Entities.User;
import com.example.book_my_show.Repositories.ShowRepository;
import com.example.book_my_show.Repositories.TicketRepository;
import com.example.book_my_show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JavaMailSender javaMailSender;





    public String addTicket(BookTicketEntryDto bookTicketEntryDto) throws Exception{

        Ticket ticket = TicketConvertor.convertDtoToEntity(bookTicketEntryDto);

        boolean isValidRequest = checkIsValidRequest(bookTicketEntryDto);

        if(isValidRequest==false){
            throw new Exception("Requested seats are not available");
        }

        Show show = showRepository.findById(bookTicketEntryDto.getShowId()).get();

        List<ShowSeats> seatsList = show.getSeatsList();

        List<String> requestedSeats = bookTicketEntryDto.getRequestedSeats();

        int totalAmount =0;

        for(ShowSeats showSeats : seatsList){
            if(requestedSeats.contains(showSeats.getSeatNo())) {
                totalAmount += showSeats.getPrice();
                showSeats.setBooked(true);
                showSeats.setBookedAt(new Date());
            }
        }
        ticket.setTotalAmount(totalAmount);
       ticket.setMovieName(show.getMovie().getMovieName());

       ticket.setShowDate(show.getShowDate());

       ticket.setShowTime(show.getShowTime());

       ticket.setTheaterName(show.getTheater().getName());


       String allotedSeats = getAllotedSeatsFromShowSeats(seatsList);

       ticket.setBookedSeats(allotedSeats);


        User user = userRepository.findById(bookTicketEntryDto.getUserId()).get();

       ticket.setUser(user);

       ticket.setShow(show);

       List<Ticket> ticketList = show.getBookedTicketList();
       ticketList.add(ticket);

       show.setBookedTicketList(ticketList);

       showRepository.save(show);

       List<Ticket> ticketList1 = user.getBookedTickets();

       ticketList1.add(ticket);

       user.setBookedTickets(ticketList1);

       userRepository.save(user);

       String body = "Hi this is to confirm your booking for seat No"+ allotedSeats+"for the movie:"+ ticket.getMovieName();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("chandantalavar001@gmail.com");
        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject("confirming your ticket");

        javaMailSender.send(mimeMessage);


       return "ticket booked";



    }

    private String getAllotedSeatsFromShowSeats(List<ShowSeats> showSeatsList){
        String result = "";
        for(ShowSeats showSeats : showSeatsList){
            result = result+showSeats.getSeatNo() +", ";
        }

        return result;
    }

    private boolean checkIsValidRequest(BookTicketEntryDto bookTicketEntryDto){
        int showId = bookTicketEntryDto.getShowId();

        List<String> requestedSeats = bookTicketEntryDto.getRequestedSeats();
        Show show = showRepository.findById(showId).get();

        List<ShowSeats> seatsList = show.getSeatsList();

        for(ShowSeats showSeats: seatsList){
            String seatNo = showSeats.getSeatNo();

            if(requestedSeats.contains(seatNo)){
                if(showSeats.isBooked()==true){
                    return false;
                }
            }
        }


        return true;


    }
}
