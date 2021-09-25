package com.example.vuetilserver.dto;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.dto.global.GlobalBasicModelInterface;
import lombok.*;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDto {


    @Getter
    @Setter
    public static class ResponseEntity{

    }

    @Getter
    @Setter
    public static class modelIdentity implements GlobalBasicModelInterface<Member> {
        private Long id;

        @Override
        public void modeling(Member member) {
            this.id = member.getId();
        }
    }

    @Getter
    @Setter
    public static class modelBasic extends MemberDto.modelIdentity{
        private char delYn;

        private char useYn;

        public void modeling(Member member){
            super.modeling(member);
        }
    }

    @Getter
    @Setter
    public static class insertMember extends modelBasic{

        private String username;

        private String password;

        private String nickname;

        public Supplier<Member> toEntity(){
            return () -> Member.builder()
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
        private String token;

        public loginMemberResponse(String username, String nickname, String success, String token){
            this.username = username;
            this.nickname = nickname;
            this.success = success;
            this.token = token;
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
