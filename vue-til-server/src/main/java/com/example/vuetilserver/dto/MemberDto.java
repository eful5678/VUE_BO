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
    @Getter
    @Setter
    public static class loginMember{
        private String username;
        private String password;
        public loginMember(String username, String password){
            this.username = username;
            this.password = password;
        }
    }

    @Getter
    @Setter
    public static class loginMemberResponse{
        private String username;
        private String nickname;
        private String success;

        public loginMemberResponse(String username, String nickname){
            this.username = username;
            this.nickname = nickname;
        }
        public loginMemberResponse(String success){
            this.success = success;
        }
        public loginMemberResponse(){

        }
    }

//    @Getter
//    @Setter
//    @NoArgsConstructor
//    public static class insert{
//
//    }


}
