package com.workbook.demo.member.repository;

import com.workbook.demo.member.Member;

public class MemberRepositoryImpl implements MemberRepository{

    @Override
    public Member find(String memberId){

        //SQL 실행

        Member member = new Member("a","b","c","d");
        return member;
    }

}
