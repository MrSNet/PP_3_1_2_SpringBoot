package com.student.Kata.PP_3_1_2_SpringBoot.dao;



import com.student.Kata.PP_3_1_2_SpringBoot.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User updateUser(User user);
    List<User> listUsers();
    void deleteUserById(Long id);
    User findById (Long id);
}
