package org.meetpl.recodingserver.domain.review.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.review.dto.ReviewDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static org.meetpl.recodingserver.domain.codereview.domain.QCodeReview.codeReview;
import static org.meetpl.recodingserver.domain.member.domain.QMember.member;
import static org.meetpl.recodingserver.domain.review.domain.QReview.review;
import static org.meetpl.recodingserver.domain.reviewee.domain.QReviewee.reviewee;
import static org.meetpl.recodingserver.domain.reviewer.domain.QReviewer.reviewer;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewCustomRepositoryImpl implements ReviewCustomRepository {
    private final JPAQueryFactory queryFactory;


    @Override
    public Page<ReviewDetailDto> findReviewDetailDtoListByReviewerId(Long reviewerId, Pageable pageable) {
        List<ReviewDetailDto> contents = queryFactory
                .select(Projections.constructor(ReviewDetailDto.class,
                        review,
                        member.name,
                        member.profile,
                        codeReview.request,
                        codeReview.projectInfo
                ))
                .from(review)
                .leftJoin(review.reviewee, reviewee)
                .leftJoin(reviewee.codeReview, codeReview)
                .leftJoin(codeReview.reviewer, reviewer)
                .where(
                        eqReviewerId(reviewerId)
                )
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(review.id.countDistinct())
                .from(review)
                .leftJoin(review.reviewee, reviewee)
                .leftJoin(reviewee.codeReview, codeReview)
                .leftJoin(codeReview.reviewer, reviewer)
                .where(
                        eqReviewerId(reviewerId)
                );

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchCount);
    }

    @Override
    public Long findReviewCountByReviewerId(Long reviewerId) {
        return queryFactory
                .select(review.id.countDistinct())
                .from(review)
                .leftJoin(review.reviewee, reviewee)
                .leftJoin(reviewee.codeReview, codeReview)
                .leftJoin(codeReview.reviewer, reviewer)
                .where(
                        eqReviewerId(reviewerId)
                )
                .fetchOne();
    }

    private BooleanExpression eqReviewerId(Long reviewerId) {
        return reviewerId != null ? reviewer.id.eq(reviewerId) : null;
    }
}
