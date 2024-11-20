package com.sra.inventory.service.domain.entity;

import com.sra.domain.entity.AggregateRoot;
import com.sra.domain.valueobject.UserId;

public class User extends AggregateRoot<UserId> {
    public User() {
    }

    public User(UserId userId) {
        super.setId(userId);
    }
}
