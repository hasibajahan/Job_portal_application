package com.sbProjects.jobPortal.services;

import com.sbProjects.jobPortal.entity.UsersType;
import com.sbProjects.jobPortal.repository.UsersTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {
    private final UsersTypeRepository usersTypeRepository;

    public UsersTypeService(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }
    public List<UsersType> getAll(){
        return usersTypeRepository.findAll();
    }
}
