package com.example.vuetilserver.domain;

import com.example.vuetilserver.domain.global.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    protected Post(String title,
                   String contents,
                   Member member,
                   LocalDateTime createDateTime,
                   char delYn,
                   char useYn){
        super(createDateTime, delYn, useYn);
        this.title = title;
        this.contents = contents;
        this.member = member;
    }


    public Post(){

    }
}
