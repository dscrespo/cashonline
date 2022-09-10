package com.example.cashonline.service;

import com.example.cashonline.persistence.store.UserStore;
import com.example.cashonline.pojo.api.user.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserStore userStore;

    public UserTO findById(long id) {
        return userStore.findById(id);
    }

    public void deleteUserById(long id) {
        userStore.deleteUserById(id);
    }

    public void createUSer(UserTO request) {
        userStore.createUSer(request);
    }
}
