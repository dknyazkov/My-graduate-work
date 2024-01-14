package com.example;

public class UserService {
    private UserRepository userRepository;
    private UserValidator validator;


    public UserService(UserRepository userRepository, UserValidator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    User save(User user){
        validator.validate(user);
        User user1 = userRepository.saveUser(user);
        return user;

    }

}
