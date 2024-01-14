package com.example;

import com.example.exception.PersonErrorException;
import org.mapstruct.control.MappingControl;

public class UserValidator {


    void validate(User user){
        if (user==null||user.getUsername()==null||user.getPassword()==null||user.getPassword().length()<5)
        {throw new PersonErrorException("create person error");}


    }
}
