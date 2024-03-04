package com.study.board.entity;

import com.study.board.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto_increment
    private Long id; //mariadb 에 들어있는 내용과 동일하게 작성

    //@Column(unique = true)
    private String memberEmail;

   //@Column
    private String memberPassword;

    //@Column
    private String memberName;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());

        return memberEntity;

    }


}
