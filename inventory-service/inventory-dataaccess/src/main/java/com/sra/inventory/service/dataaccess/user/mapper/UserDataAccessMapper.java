package com.sra.inventory.service.dataaccess.user.mapper;

import com.sra.domain.valueobject.UserId;
import com.sra.inventory.service.dataaccess.user.entity.UserEntity;
import com.sra.inventory.service.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessMapper {

    public User userEntityToUser(UserEntity userEntity) {
        return new User(new UserId(userEntity.getId()));
    }

}