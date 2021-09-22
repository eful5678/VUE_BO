package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryManagerImpl implements MemberRepositoryManager {

    private final EntityManager em;

    public Member insertMember(MemberDto.insertMember insertMember){
        final Member member = insertMember.toEntity().get();
        em.persist(member);

        return member;
    }
}
