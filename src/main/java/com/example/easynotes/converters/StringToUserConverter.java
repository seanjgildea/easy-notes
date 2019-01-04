package com.example.easynotes.converters;

import com.example.easynotes.model.User;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToUserConverter implements Converter<String, User>{

    @Autowired
    UserRepository userRepository;

    @Override
    public User convert(String id) {
        try {
            Long userId = Long.valueOf(id);
            return userRepository.getOne(userId);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
