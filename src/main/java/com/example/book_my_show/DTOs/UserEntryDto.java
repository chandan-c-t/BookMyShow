package com.example.book_my_show.DTOs;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntryDto {

    private String name;

    private int age;


    private String email;


    private String mobNo;

    private String address;
}
