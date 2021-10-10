package com.example.vuetilserver.domain;

import com.example.vuetilserver.domain.global.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
                   LocalDateTime updateDateTime,
                   char delYn,
                   char useYn){
        super(createDateTime, updateDateTime, delYn, useYn);
        this.title = title;
        this.contents = contents;
        this.member = member;
    }

    public void doRemove(Post post){
        this.destroy(post);
    }

    public void doChange(Post post){
        this.title = post.getTitle();
        this.contents = post.getContents();
    }

    public Post destroy(Post post){
        this.delYn = 'Y';
        this.useYn = 'N';
        return post;
    }




}
