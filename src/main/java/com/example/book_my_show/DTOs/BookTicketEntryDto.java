package com.example.book_my_show.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class BookTicketEntryDto {

    private int showId;

    private List<String> requestedSeats = new ArrayList<>();

    private int userId;
}
