package com.workbook.demo.member.repository;

import com.workbook.demo.member.Member;
import org.springframework.stereotype.Repository;

@Repository
interface MemberRepository {

    public Member find(String MmmberId);

}
