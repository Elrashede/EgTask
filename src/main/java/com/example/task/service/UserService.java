package com.example.task.service;

import com.example.task.model.User;
import com.example.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User>getAll(){
        return (List<User>) userRepository.findAll();
    }
    public Optional<User> getUser(int id){
        return userRepository.findById(id);
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User updateUser(int id,User user){
          User updatedUser=userRepository.findById(id).get();
          updatedUser.setName(user.getName());
          userRepository.save(updatedUser);
          return updatedUser;
    }
    public String deleteUser(int id){
        User deletedUser=userRepository.findById(id).get();
        userRepository.delete(deletedUser);
        return "User Deleted Successfuly";
    }



}
