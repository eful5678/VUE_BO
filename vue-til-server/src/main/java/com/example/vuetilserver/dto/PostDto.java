package com.example.vuetilserver.dto;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PostDto {

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
