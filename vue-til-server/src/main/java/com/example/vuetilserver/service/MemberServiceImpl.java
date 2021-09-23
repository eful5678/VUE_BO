package com.example.vuetilserver.service;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.dto.MemberDto;
import com.example.vuetilserver.repository.MemberRepositoryManager;
import com.example.vuetilserver.repository.MemberRepositorySupport;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @NonNull
    private final MemberRepositoryManager memberRepositoryManager;

    @NonNull
    private final MemberRepositorySupport memberRepositorySupport;

    public Member insertMember(MemberDto.insertMember insertMember){

        final Member member = memberRepositoryManager.insertMember(insertMember);

        return member;
    }

    @Override
    public MemberDto.loginMemberResponse loginMember(MemberDto.loginMember loginMember) {

        MemberDto.loginMemberResponse member = memberRepositorySupport.findMemberByUsernameAndPassword(loginMember);
        if(member.getUsername() != null){
            return member;
        }else{
            return null;
//            System.out.println("login 실패");
        }
//
//        Member member = memberRepositorySupport.findMemberByUsernameAndPassword(loginMember);
////        MemberDto.loginMemberResponse()
//        System.out.println(member.getUsername());

//        return new MemberDto.loginMemberResponse(member.getUsername(), member.getPassword());

    }
}
