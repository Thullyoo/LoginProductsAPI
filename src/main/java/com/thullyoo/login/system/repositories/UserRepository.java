package com.thullyoo.login.system.repositories;

import com.thullyoo.login.system.entities.role.Role;
import com.thullyoo.login.system.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

}
