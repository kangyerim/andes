package com.andes.web.mappers;

import com.andes.web.member.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    public Member login(Member param);
}
