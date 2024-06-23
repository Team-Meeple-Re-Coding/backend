package org.meetpl.recodingserver.domain.member.repository;

import org.meetpl.recodingserver.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
