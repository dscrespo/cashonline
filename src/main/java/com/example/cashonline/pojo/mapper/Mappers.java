package com.example.cashonline.pojo.mapper;

import com.example.cashonline.persistence.entity.User;
import com.example.cashonline.pojo.api.user.UserTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Mappers {

    UserTO userToUserTO(User user);
    User userTOToUser(UserTO userTO);
}
