package com.example.vuetilserver.api;

import com.example.vuetilserver.config.JwtTokenProvider;
import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.dto.MemberDto;
import com.example.vuetilserver.repository.UserRepository;
import com.example.vuetilserver.service.CustomUserDetailService;
import com.example.vuetilserver.service.MemberService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080")
public class MemberController {

    private final MemberService memberService;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;


//    @PostMapping("/insert")
//    public Member insertMember(@RequestBody MemberDto.insertMember member){
//        System.out.println("asdfasdf");
//        System.out.println(member);
//        return memberService.insertMember(member);
//    }

    @PostMapping("/insertV2")
    public Long insertMemberV2(@RequestBody MemberDto.insertMember insertMember){
        return userRepository.save(Member.builder()
                .username(insertMember.getUsername())
                .nickname(insertMember.getNickname())
                .password(passwordEncoder.encode(insertMember.getPassword()))
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build()).getId();
    }

    @PostMapping("/loginV2")
    public MemberDto.loginMemberResponse login(@RequestBody @NotNull MemberDto.loginMember loginMember) {
        Member member = userRepository.findByUsername(loginMember.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(loginMember.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return new MemberDto.loginMemberResponse(member.getUsername(),member.getNickname(),"true",jwtTokenProvider.createToken(member.getUsername(), member.getRoles()));
    }

//    @GetMapping("/login")
//    @CrossOrigin(origins = "http://localhost:8080")
//    public MemberDto.loginMemberResponse loginMember(@ModelAttribute MemberDto.loginMember loginMember){
//        System.out.println(loginMember);
//        return memberService.loginMember(loginMember);
//    }

}
