package com.example.cashonline.service;

import com.example.cashonline.persistence.store.UserStore;
import com.example.cashonline.pojo.api.user.UserTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserStore userStore;

    public UserTO findById(long id) {
            logger.info("buscando un usuario con el id {}", id);
            return userStore.findById(id);
    }

    public void deleteUserById(long id) {
        logger.info("borrando un usuario con el id {}", id);
        userStore.deleteUserById(id);
    }

    public void createUSer(UserTO request)
    {
        logger.info("creando un usuario con los siguientes parametros: {} {}", request.getFirstName(), request.getLastName());
        userStore.createUSer(request);
    }
}
