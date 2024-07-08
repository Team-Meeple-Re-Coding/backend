package org.meetpl.recodingserver.domain.reviewer.repository;

import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long>, ReviewerRepositoryCustom {
    Optional<Reviewer> findReviewerByMemberId(Long memberId);
}