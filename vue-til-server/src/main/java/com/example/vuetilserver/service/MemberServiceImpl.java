package com.example.vuetilserver.service;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.dto.MemberDto;
import com.example.vuetilserver.repository.MemberRepositoryManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepositoryManager memberRepositoryManager;

    public Member insertMember(MemberDto.insertMember insertMember){

        final Member member = memberRepositoryManager.insertMember(insertMember);

        return member;
    }
}
