package com.example.vuetilserver.dto;

import com.example.vuetilserver.domain.Member;
import lombok.*;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDto {

    @Getter
    @Setter
    public static class insertMember{
        private Long id;

        private String username;

        private String password;

        private String nickname;

        public Supplier<Member> toEntity(){
            return () -> Member.builder()
                    .id(this.id)
                    .username(this.username)
                    .nickname(this.nickname)
                    .password(this.password)
                    .build();
        }
    }

//    @Getter
//    @Setter
//    @NoArgsConstructor
//    public static class insert{
//
//    }


}
