package org.meetpl.recodingserver.domain.reviewer.repository;

import org.meetpl.recodingserver.domain.reviewer.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CareerRepository extends JpaRepository<Career, Long> {
    Optional<Career> findByReviewerId(Long reviewerId);
}
