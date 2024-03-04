package com.study.board.service;

import com.study.board.dto.MemberDTO;
import com.study.board.entity.MemberEntity;
import com.study.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        //1. dto > entity로 변환
        //2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
        //repository의 save메서트 호출(조건. entity객체를 넘겨줘야함)
    }

    public MemberDTO login(MemberDTO memberDTO) {
        //1. 회원이 입력한 이메일로 DB에서 조회를 함 2. DB에서 조회한 비밀번호와 사용자가 입력한 비번이 일치하는지 판단
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            //조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                //비밀번호 일치
                //entity 객체를 dto 객체로 변환 후 리턴
                MemberDTO dto = MemberDTO.memberDTO(memberEntity); //에러나면 여기도 확인해보기
                return dto;
            }else {
                //비밀번호 불일치(로그인 실패)
                return null;
            }
        } else {
            //조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }

    }
}