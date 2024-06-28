package org.meetpl.recodingserver.domain.review.repository;

import org.meetpl.recodingserver.domain.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository{
}
