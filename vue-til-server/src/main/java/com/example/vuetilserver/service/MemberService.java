package com.example.vuetilserver.service;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.dto.MemberDto;

import java.util.List;

public interface MemberService{

    Member insertMember(MemberDto.insertMember member);

//    MemberDto.loginMemberResponse loginMember(MemberDto.loginMember loginMember);
}
