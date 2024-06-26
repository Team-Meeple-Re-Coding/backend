package org.meetpl.recodingserver.domain.reviewer.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.meetpl.recodingserver.api.search.service.dto.req.SearchReqDto;
import org.meetpl.recodingserver.domain.reviewer.domain.*;
import org.meetpl.recodingserver.domain.codereview.domain.SkillType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewerRepositoryImpl implements ReviewerRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ReviewerRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<Reviewer> findReviewerBySearchReqDto(Pageable pageable, SearchReqDto searchReqDto) {
        QReviewer reviewer = QReviewer.reviewer;
        QCareer career = QCareer.career;
        QSkill skill = QSkill.skill;

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
}