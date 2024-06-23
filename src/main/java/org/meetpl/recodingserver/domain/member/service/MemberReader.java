package org.meetpl.recodingserver.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.domain.member.repository.MemberRepository;
import org.meetpl.recodingserver.global.error.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import static org.meetpl.recodingserver.global.error.ErrorCode.MEMBER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class MemberReader {
    private final MemberRepository memberRepository;
    public Member getMemberById(Long memberId){
        return memberRepository.findById(memberId).orElseThrow( () -> new EntityNotFoundException(MEMBER_NOT_FOUND));
    }
}
