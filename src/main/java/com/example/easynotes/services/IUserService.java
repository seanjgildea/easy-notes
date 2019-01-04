package com.example.easynotes.services;

import com.example.easynotes.exception.EmailExistsException;
import com.example.easynotes.model.User;

public interface IUserService {
    User registerNewUserAccount(User accountDto)
            throws EmailExistsException;
}
