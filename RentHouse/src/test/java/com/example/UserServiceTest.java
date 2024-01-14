package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.control.MappingControl;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserValidator validator=new UserValidator();
    UserRepository repository=new UserRepository();
    UserService userService=new UserService(repository,validator);
    @Test
    void save(){
        User user=new User("Peter","Peter@gmail.com","+375297063453","12345");
        User save = userService.save(user);
        Assertions.assertEquals("Peter",save.getUsername());
        Assertions.assertEquals("Peter@gmail.com",save.getUsername());
        Assertions.assertEquals("Peter",save.getUsername());
        Assertions.assertEquals("Peter",save.getUsername());


    }


}