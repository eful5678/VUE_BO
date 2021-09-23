package com.example.vuetilserver.api;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.dto.MemberDto;
import com.example.vuetilserver.service.MemberService;
import com.example.vuetilserver.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080")
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/insert")
    public Member insertMember(@RequestBody MemberDto.insertMember member){
        System.out.println("asdfasdf");
        System.out.println(member);
        return memberService.insertMember(member);
    }

    @GetMapping("/login")
    @CrossOrigin(origins = "http://localhost:8080")
    public MemberDto.loginMemberResponse loginMember(@ModelAttribute MemberDto.loginMember loginMember){
        System.out.println(loginMember);
        return memberService.loginMember(loginMember);
    }
}
