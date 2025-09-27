package com.sbProjects.jobPortal.controller;

import com.sbProjects.jobPortal.entity.Users;
import com.sbProjects.jobPortal.entity.UsersType;
import com.sbProjects.jobPortal.services.UsersService;
import com.sbProjects.jobPortal.services.UsersTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {
    private final UsersTypeService usersTypeService;

    private final UsersService usersService;
    @Autowired
    public UsersController(UsersTypeService usersTypeService,UsersService usersService){
        this.usersTypeService=usersTypeService;
        this.usersService=usersService;
    }


    //method to show our user registration form
    @GetMapping("/register")
    public String register(Model model){
        List<UsersType> usersTypes=usersTypeService.getAll();
        model.addAttribute("getAllTypes",usersTypes);
        model.addAttribute("user",new Users());
        return "register";
    }
    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users){
        //System.out.println("Users:: "+users);
        usersService.addNew(users);
        return "dashboard";
    }
}
