package com.example.book_my_show.Convertors;

import com.example.book_my_show.DTOs.UserEntryDto;
import com.example.book_my_show.Entities.User;

public class UserConvertor {

    public static User convertDtoToEntity(UserEntryDto userEntryDto){
        User user= User.builder().age(userEntryDto.getAge()).name(userEntryDto.getName()).mobNo(userEntryDto.getMobNo()).email(userEntryDto.getEmail()).address(userEntryDto.getAddress()).build();
        return user;
    }
}
