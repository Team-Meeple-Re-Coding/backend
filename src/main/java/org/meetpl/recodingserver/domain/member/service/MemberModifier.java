package org.meetpl.recodingserver.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberModifier {
    private final MemberRepository memberRepository;
    public Member save(Member member){
        return memberRepository.save(member);
    }
}
