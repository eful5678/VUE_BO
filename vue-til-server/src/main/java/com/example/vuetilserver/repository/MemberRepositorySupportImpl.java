package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class MemberRepositorySupportImpl extends QuerydslRepositorySupport implements MemberRepositorySupport{

    private final JPAQueryFactory jpaQueryFactory;

    public MemberRepositorySupportImpl(EntityManager em){
        super(Member.class);
        super.setEntityManager(em);
        jpaQueryFactory = new JPAQueryFactory(em);
    }

    public Member findMemberByUsername(String username){
        QMember member = QMember.member;

        return jpaQueryFactory.select(member)
                .from(member)
                .where(member.username.eq(username))
                .fetchFirst();
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
