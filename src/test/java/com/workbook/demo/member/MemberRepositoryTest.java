package com.workbook.demo.member;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EntityManager entityManager; // jpa 엔티티 관리자

    @Test
    void 멤버_생성_시_createdAt_updatedAt_자동_설정 (){

        //given
        Member member = new Member("uuid-1", "aaa@example.com", "member1","profile1.png");

        //when
        Member savedMember = memberRepository.save(member);

        //then
        assertThat(savedMember.getCreatedAt()).isNotNull();
        assertThat(savedMember.getUpdatedAt()).isNotNull();
        assertThat(savedMember.getCreatedAt()).isEqualTo(savedMember.getUpdatedAt());

    }

    @Test
    void 멤버_수정_시_updatedAt_자동_설정 () throws InterruptedException {

        //given
        Member member = new Member("uuid-1", "aaa@example.com", "member1","profile1.png");
        Member savedMember = memberRepository.save(member);

        //when
        Thread.sleep(1000);
        savedMember.setUserName("updatedUserName");
        memberRepository.save(savedMember);
        entityManager.flush(); // 영속성 컨텍스트를 db에 반영

        //then
        assertThat(savedMember.getCreatedAt()).isNotEqualTo(savedMember.getUpdatedAt());
        assertThat(savedMember.getUpdatedAt()).isAfter(savedMember.getCreatedAt());
    }

}
