package com.bdtube.bdtube.Service;

import com.bdtube.bdtube.Model.User;
import com.bdtube.bdtube.Repository.UserRepository;
import com.bdtube.bdtube.Repository.VideoDemanderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicelmpl implements UserService {
    @Autowired
    private    UserRepository ur ;
    public UserServicelmpl( UserRepository ur) {
        this.ur = ur;
    }
    @Override
    public List<User> getAll() {
        return (List<User>) ur.findAll();
    }
    @Override
    public void adduser(User user) {
        ur.save(user);
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public Optional<User> getUserByid(int id) {
        return Optional.empty();
    }

    @Override
    public void updateUser(User user) {
 ur.save(user);
    }

    @Override
    public User find(String userName) {
        return null;
    }


}
