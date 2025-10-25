package com.sbProjects.jobPortal.services;

import com.sbProjects.jobPortal.entity.JobSeekerProfile;
import com.sbProjects.jobPortal.entity.RecruiterProfile;
import com.sbProjects.jobPortal.entity.Users;
import com.sbProjects.jobPortal.repository.JobSeekerProfileRepository;
import com.sbProjects.jobPortal.repository.RecruiterProfileRepository;
import com.sbProjects.jobPortal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    private final JobSeekerProfileRepository jobSeekerProfileRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository,
                        RecruiterProfileRepository recruiterProfileRepository,
                        JobSeekerProfileRepository jobSeekerProfileRepository) {
        this.usersRepository = usersRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
    }


    //method to register/add a new user
    public Users addNew(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUser=usersRepository.save(users);
        int userTypeId= users.getUserTypeId().getUserTypeId();
        //check what type of user it is-(recruiter or job seeker)
        if(userTypeId==1){
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        }
        else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }
        return savedUser;
    }

    public Optional<Users> getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }


}
