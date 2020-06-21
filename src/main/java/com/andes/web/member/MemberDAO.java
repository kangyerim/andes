package com.andes.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class MemberDAO {

    @Autowired JdbcTemplate jdbcTemplate;

    public void create(Member member) {
        String query = "insert into mariadb.member(user_id, password, user_name, birth_date) values(?,?,?,?)";
        jdbcTemplate.update(query, member.getUserId(), member.getPassword(), member.getUserName(), member.getBirthDate());
    }

    public List<Member> list() {
        List<Member> result = jdbcTemplate.query(
                "select member_no, user_id, password, user_name, birth_date from mariadb.member where member_no > 0 order by member_no",
                new RowMapper<Member>(){
                    public Member mapRow(ResultSet result, int rowNum) throws SQLException {
                        Member member = new Member();
                        member.setMemberNo(result.getInt("member_no"));
                        member.setUserId(result.getString("user_id"));
                        member.setPassword(result.getString("password"));
                        member.setUserName(result.getString("user_name"));
                        member.setBirthDate(result.getString("birth_date"));
                        return member;
                    }
                }
        );
        return result;
    }

    public Member detail(String userId) {
        List<Member> result = jdbcTemplate.query(
                "select member_no, user_id, password, user_name, birth_date from mariadb.member where member_no = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();
                        member.setMemberNo(rs.getInt("member_no"));
                        member.setUserId(rs.getString("user_id"));
                        member.setPassword(rs.getString("password"));
                        member.setUserName(rs.getString("user_name"));
                        member.setBirthDate(rs.getString("birth_date"));
                        return member;
                    }
                },
                userId
        );
        return result.isEmpty() ? null : result.get(0);
    }

    public void uptate(Member member) {
        String query = "update mariadb.member set member_id = ?, password = ?, birth_date = ? where member_no = ?";
        jdbcTemplate.update(query, member.getUserId(), member.getPassword(), member.getBirthDate());
    }

    public void delete(Member member) {
        String query = "delete from mariadb.member where member_no = ?";
        jdbcTemplate.update(query, member);
    }

//    public boolean login(Member member) {
//        boolean ok = false;
//        String check = "select user_id, password  from mariadb.member where user_id like #{member.userId} and password like #{password}";
//        if(check != null){
//            ok = true;
//        }
//        return ok;
//    }
}
