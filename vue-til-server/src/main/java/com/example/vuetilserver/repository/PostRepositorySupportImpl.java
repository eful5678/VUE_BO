package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.domain.Post;
import com.example.vuetilserver.domain.QMember;
import com.example.vuetilserver.domain.QPost;
import com.example.vuetilserver.dto.PostDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PostRepositorySupportImpl extends QuerydslRepositorySupport implements PostRepositorySupport{

    private final JPAQueryFactory jpaQueryFactory;

    public PostRepositorySupportImpl(EntityManager em){
        super(Post.class);
        super.setEntityManager(em);
        jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<PostDto.PostList> search() {

        final QPost post = QPost.post;
        final QMember member = QMember.member;

        final BooleanExpression isUseYn = post.useYn.eq('Y');
        final BooleanExpression isDelYn = post.delYn.eq('N');

        List<PostDto.PostList> result = jpaQueryFactory.select(Projections.constructor(PostDto.PostList.class, post
                                                        ,member.username
                                                        ,member.nickname))
                                .from(post)
                                .join(member)
                                .on(post.member.id.eq(member.id))
                                .where(isUseYn
                                    .and(isDelYn))
                                .fetch();
        if(result.size() > 0){
            return result;
        }else{
            System.out.println("결과없음");
        }
        return result;
    }

    @Override
    public Post findPostById(Long postId) {

        QPost post = QPost.post;

        return jpaQueryFactory.select(post)
                .from(post)
                .where(post.id.eq(postId))
                .fetchOne();
    }
}
