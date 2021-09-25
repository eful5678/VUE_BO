package com.example.vuetilserver.service;

import com.example.vuetilserver.config.JwtTokenProvider;
import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.domain.User;
import com.example.vuetilserver.dto.MemberDto;
import com.example.vuetilserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

//    public Long join(MemberDto.insertMember insertMember){
//        return userRepository.save(Member.builder()
//                .username(insertMember.getUsername())
//                .password(passwordEncoder.encode(insertMember.getPassword()))
//                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
//                .build()).getId();
//    }
}
