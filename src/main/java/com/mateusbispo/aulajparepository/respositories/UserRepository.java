package com.mateusbispo.aulajparepository.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateusbispo.aulajparepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
