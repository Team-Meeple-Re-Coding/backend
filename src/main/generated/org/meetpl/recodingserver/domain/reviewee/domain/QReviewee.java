package org.meetpl.recodingserver.domain.reviewee.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewee is a Querydsl query type for Reviewee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewee extends EntityPathBase<Reviewee> {

    private static final long serialVersionUID = 1684505129L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewee reviewee = new QReviewee("reviewee");

    public final StringPath applicationFormLink = createString("applicationFormLink");

    public final StringPath chattingLink = createString("chattingLink");

    public final org.meetpl.recodingserver.domain.codereview.domain.QCodeReview codeReview;

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final org.meetpl.recodingserver.domain.member.domain.QMember member;

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public QReviewee(String variable) {
        this(Reviewee.class, forVariable(variable), INITS);
    }

    public QReviewee(Path<? extends Reviewee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewee(PathMetadata metadata, PathInits inits) {
        this(Reviewee.class, metadata, inits);
    }

    public QReviewee(Class<? extends Reviewee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.codeReview = inits.isInitialized("codeReview") ? new org.meetpl.recodingserver.domain.codereview.domain.QCodeReview(forProperty("codeReview"), inits.get("codeReview")) : null;
        this.member = inits.isInitialized("member") ? new org.meetpl.recodingserver.domain.member.domain.QMember(forProperty("member")) : null;
    }

}

