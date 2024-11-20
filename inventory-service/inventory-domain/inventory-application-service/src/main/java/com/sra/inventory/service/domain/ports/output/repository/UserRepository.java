package com.sra.inventory.service.domain.ports.output.repository;

import com.sra.inventory.service.domain.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findUser(UUID userId);
}