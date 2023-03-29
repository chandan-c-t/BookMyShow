package com.example.book_my_show.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TheaterEntryDto {

   private  String name;

   private String location;

   private int classicSeatsCount;

   private int premiumSeatsCount;

}
