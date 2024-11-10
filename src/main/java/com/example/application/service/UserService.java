package com.example.application.service;

import com.example.application.data.User;
import com.example.application.data.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  public void addUser(User user) {
    userRepository.save(user);
  }

  public List<User> searchUsers(String text) {
    return userRepository.search(text);
  }

  public void delete(User user) {
    userRepository.delete(user);
  }
}
