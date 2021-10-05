package com.example.vuetilserver.dto;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.domain.Post;
import com.example.vuetilserver.dto.global.GlobalBasicModelInterface;
import com.example.vuetilserver.dto.global.GlobalLazyModelInterface;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostDto {

    @Getter
    @Setter
    public static class modelIdentity implements GlobalBasicModelInterface<Post>{
        private Long postId;

        @Override
        public void modeling(Post post) {
            this.postId = post.getId();
        }
    }

    @Getter
    @Setter
    public static class modelBasic extends PostDto.modelIdentity{

        private LocalDateTime createDateTime;

        private char useYn;

        private char delYn;

        public void modeling(Post post){
            super.modeling(post);
            this.createDateTime = post.getCreateDateTime();
            this.useYn = post.getUseYn();
            this.delYn = post.getDelYn();
        }
    }

    @Getter
    @Setter
    public static class PostInsert{

        private String title;

        private String contents;

        private String username;



        public Supplier<Post> toEntity(Member member){
            return () -> Post.builder()
                    .title(this.title)
                    .contents(this.contents)
                    .member(member)
                    .build();
        }

        public PostInsert(String title, String content){
            this.title = title;
            this.contents = contents;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Insert extends PostDto.modelBasic implements GlobalLazyModelInterface<Post, PostDto.Insert> {
        public Insert(Post post){
            this.modeling(post);
        }

        @Override
        public Insert lazyModeling(Post post) {
            this.modeling(post);
            return this;
        }
    }

    @Getter
    @Setter
    public static class PostList{

        private Long id;

        private String writer;

        private String contents;

        private String title;

        public PostList(String writer, String contents){
            this.writer = writer;
            this.contents = contents;
        }
        public PostList(){

        }
        public PostList(Post post, Member member){
            this.id = post.getId();
            this.contents = post.getContents();
            this.title = post.getTitle();
            this.writer = member.getNickname();
        }
    }
}
