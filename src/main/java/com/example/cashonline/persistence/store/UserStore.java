package com.example.cashonline.persistence.store;

import com.example.cashonline.persistence.repository.UserRepository;
import com.example.cashonline.pojo.api.user.UserTO;
import com.example.cashonline.pojo.mapper.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserStore {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mappers mappers;

    public UserTO findById(long id) {
        return mappers.userToUserTO(userRepository.findById(id).get());
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public void createUSer(UserTO request) {
        userRepository.save(mappers.userTOToUser(request));
    }

}
