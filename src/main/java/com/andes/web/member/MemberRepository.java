package com.andes.web.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

//    public void updatePassword(String userId, String update);

    public void deleteByUserId(String userId);
}
