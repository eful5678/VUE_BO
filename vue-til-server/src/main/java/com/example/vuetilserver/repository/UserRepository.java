package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);
}
