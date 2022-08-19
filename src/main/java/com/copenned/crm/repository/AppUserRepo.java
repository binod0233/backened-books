package com.copenned.crm.repository;

import com.copenned.crm.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Integer> {
    AppUser findByEmail(String email);

    List<AppUser> findAllByRole(String role);




}
