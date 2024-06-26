package org.meetpl.recodingserver.domain.member.repository;

import org.meetpl.recodingserver.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByPlatformId(String platformId);
}
