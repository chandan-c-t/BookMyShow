package com.example.book_my_show.Repositories;

import com.example.book_my_show.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
