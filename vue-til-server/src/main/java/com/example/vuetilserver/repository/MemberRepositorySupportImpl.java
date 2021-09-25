package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.domain.QMember;
import com.example.vuetilserver.dto.MemberDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import static com.example.vuetilserver.domain.QMember.member;


@Repository
public class MemberRepositorySupportImpl extends QuerydslRepositorySupport implements MemberRepositorySupport{

    private final JPAQueryFactory jpaQueryFactory;

    public MemberRepositorySupportImpl(EntityManager em){
        super(Member.class);
        super.setEntityManager(em);
        jpaQueryFactory = new JPAQueryFactory(em);
    }

//    private final EntityManager em;
//


//    private final JPAQueryFactory jpaQueryFactory;

    // 생성자
//    public MemberRepositorySupportImpl(EntityManager entityManager) {
//        super(Member.class); // QuerydslRepositorySupport
//        super.setEntityManager(entityManager);
//        jpaQueryFactory = new JPAQueryFactory(entityManager); // JPAQueryFactory
//    }

//    @Override
//    public MemberDto.loginMemberResponse findMemberByUsernameAndPassword(MemberDto.loginMember loginMember) {
//        QMember member = new QMember("member");
//        final QMember member = QMember.member;
//        final BooleanExpression isUsername = member.username.eq(loginMember.getUsername());
//        final BooleanExpression isPassword = member.password.eq(loginMember.getPassword());
//        System.out.println(member.username);
//
//        List<Member> members = jpaQueryFactory.select(member)
//                                                .from(member)
//                                                .where(isUsername
//                                                .and(isPassword))
//                                                .fetch();
//        return new MemberDto.loginMemberResponse(members.get(0).getUsername(), members.get(0).getNickname());

//        return jpaQueryFactory

//                .select(Projections.constructor(MemberDto.loginMemberResponse.class))
//                .from(member)
//                .where(isUsername
//                    .and(isPassword))
//                .fetchFirst();

//        return jpaQueryFactory.select(member)
//                .from(member)
//                .where(isUsername
//                .and(isPassword))
//                .fetchOne();
//    }
}
