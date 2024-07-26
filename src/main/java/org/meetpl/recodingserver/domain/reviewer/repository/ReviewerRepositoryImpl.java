package org.meetpl.recodingserver.domain.reviewer.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.meetpl.recodingserver.api.search.dto.req.SearchReqDto;
import org.meetpl.recodingserver.domain.reviewer.domain.*;
import org.meetpl.recodingserver.domain.reviewer.dto.ReviewerDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.meetpl.recodingserver.domain.member.domain.QMember.member;
import static org.meetpl.recodingserver.domain.reviewer.domain.QCareer.career;
import static org.meetpl.recodingserver.domain.reviewer.domain.QReviewer.reviewer;
import static org.meetpl.recodingserver.domain.reviewer.domain.QSkill.skill;

@Repository
public class ReviewerRepositoryImpl implements ReviewerRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ReviewerRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<Reviewer> findReviewerBySearchReqDto(Pageable pageable, SearchReqDto searchReqDto) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (searchReqDto.corporation() != null && !searchReqDto.corporation().isEmpty()) {
            predicate.and(reviewer.corporation.eq(searchReqDto.corporation()));
        }

        if (searchReqDto.job() != null && !searchReqDto.job().isEmpty()) {
            predicate.and(reviewer.job.stringValue().eq(searchReqDto.job()));
        }

        if (searchReqDto.career() != null && !searchReqDto.career().isEmpty()) {
            predicate.and(career.content.contains(searchReqDto.career()));
        }

        if (searchReqDto.skill() != null && !searchReqDto.skill().isEmpty()) {
            predicate.and(skill.skillType.eq(SkillType.valueOf(searchReqDto.skill())));
        }

        List<Reviewer> results = queryFactory
                .selectFrom(reviewer)
                .leftJoin(career).on(career.reviewer.eq(reviewer))
                .leftJoin(skill).on(skill.reviewer.eq(reviewer))
                .where(predicate)
                .distinct()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .selectFrom(reviewer)
                .leftJoin(career).on(career.reviewer.eq(reviewer))
                .leftJoin(skill).on(skill.reviewer.eq(reviewer))
                .where(predicate)
                .distinct()
                .fetchCount();

        return new PageImpl<>(results, pageable, total);
    }

    @Override
    public Optional<ReviewerDetailDto> findReviewerDetailById(Long reviewerId) {
        return Optional.ofNullable(queryFactory
                .select(Projections.constructor(ReviewerDetailDto.class,
                        reviewer.id,
                        member.name,
                        member.profile,
                        reviewer.corporation,
                        reviewer.githubLink,
                        reviewer.intro,
                        reviewer.codeStyle,
                        reviewer.careerInfo,
                        reviewer.careerYear,
                        reviewer.codeReviews,
                        reviewer.skills
                ))
                .from(reviewer)
                .leftJoin(reviewer.member, member)
                .where(
                        eqReviewId(reviewerId)
                )
                .fetchOne()
        );
    }

    private BooleanExpression eqReviewId(Long reviewId) {
        return reviewId != null ? reviewer.id.eq(reviewId) : null;
    }
}