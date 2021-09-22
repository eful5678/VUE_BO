package com.example.vuetilserver.api;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.dto.MemberDto;
import com.example.vuetilserver.service.MemberService;
import com.example.vuetilserver.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/insert")
    public Member insertMember(@RequestBody MemberDto.insertMember member){
        System.out.println("asdfasdf");
        System.out.println(member);
        return memberService.insertMember(member);
    }
}
