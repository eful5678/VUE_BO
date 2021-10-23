package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Member;


public interface MemberRepositorySupport {

//    MemberDto.loginMemberResponse findMemberByUsernameAndPassword(MemberDto.loginMember loginMember);

    Member findMemberByUsername(String username);
}
