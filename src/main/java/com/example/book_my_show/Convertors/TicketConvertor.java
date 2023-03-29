package com.example.book_my_show.Convertors;

import com.example.book_my_show.DTOs.BookTicketEntryDto;
import com.example.book_my_show.Entities.Ticket;

public class TicketConvertor {

    public static Ticket convertDtoToEntity(BookTicketEntryDto bookTicketEntryDto){
        Ticket ticket = new Ticket();

        return ticket;
    }
}
