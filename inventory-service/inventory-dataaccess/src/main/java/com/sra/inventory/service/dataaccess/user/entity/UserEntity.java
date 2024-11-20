package com.sra.inventory.service.dataaccess.user.entity;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_m_view", schema = "user")
@Entity
public class UserEntity {

    @Id
    private UUID id;
}
