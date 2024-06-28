package org.meetpl.recodingserver.domain.reviewer.repository;

import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long>, ReviewerRepositoryCustom {
}