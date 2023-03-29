package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.UserConvertor;
import com.example.book_my_show.DTOs.UserEntryDto;
import com.example.book_my_show.Entities.User;
import com.example.book_my_show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String addUser(UserEntryDto userEntryDto) throws  Exception{
       User user = UserConvertor.convertDtoToEntity(userEntryDto);


       userRepository.save(user);
        return "User added";
    }
}
