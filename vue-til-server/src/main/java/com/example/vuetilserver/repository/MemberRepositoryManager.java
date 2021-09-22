package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.dto.MemberDto;

public interface MemberRepositoryManager {

    Member insertMember(MemberDto.insertMember member);
}
