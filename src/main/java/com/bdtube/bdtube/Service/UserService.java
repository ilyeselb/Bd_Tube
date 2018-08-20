package com.bdtube.bdtube.Service;

import com.bdtube.bdtube.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAll();
    public void adduser(User user);
    public void deleteUser(int id);
    public Optional<User> getUserByid(int id);
    public void updateUser(User user);
    public User find(String userName) ;


    }
