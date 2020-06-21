package com.andes.web.member;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    public void signIn(Member member);

    public void remove(Member member);

    public void modify(Member member);

    public List<Member> listAll();

    public Member listOne(String userId);

    public Member access(Member param);
}
