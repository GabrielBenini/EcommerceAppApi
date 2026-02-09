package com.gabrielbenini.api.ecommerceapi.repository;

import com.gabrielbenini.api.ecommerceapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
