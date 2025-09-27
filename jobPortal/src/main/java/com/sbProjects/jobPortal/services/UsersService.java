package com.sbProjects.jobPortal.services;

import com.sbProjects.jobPortal.entity.Users;
import com.sbProjects.jobPortal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    @Autowired
    public UsersService(UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }
    //method to register/add a new user
    public Users addNew(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        return usersRepository.save(users);
    }
}
