package com.example.vuetilserver.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "password","nickname"})
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String password;

    private String nickname;

    @Builder
    protected Member(Long id, String username, String password, String nickname){
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }
}
