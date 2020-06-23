package com.andes.web.member;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "member")
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(length = 20, nullable = false)
    private String userId, password, userName, email;

    @Builder
    public Member(String userId, String password, String userName, String email){
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.email = email;
    }

}
