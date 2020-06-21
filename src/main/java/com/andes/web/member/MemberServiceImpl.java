package com.andes.web.member;

import com.andes.web.mappers.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired MemberDAO dao;
    @Autowired MemberMapper mapper;

    @Override
    public void signIn(Member member) {
        dao.create(member);
    }

    @Override
    public void remove(Member member) {
        dao.delete(member);
    }

    @Override
    public void modify(Member member) {
        dao.uptate(member);
    }

    @Override
    public List<Member> listAll() {
        return dao.list();
    }

    @Override
    public Member listOne(String userId) {
        return dao.detail(userId);
    }

    @Override
    public Member access(Member param) {
        System.out.println("~~~~멤버 써비스 임플");
        return mapper.login(param);
    }


}
