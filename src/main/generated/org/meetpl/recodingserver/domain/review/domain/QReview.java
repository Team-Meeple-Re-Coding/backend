package org.meetpl.recodingserver.domain.review.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = 1920956521L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final org.meetpl.recodingserver.global.common.QBaseTimeEntity _super = new org.meetpl.recodingserver.global.common.QBaseTimeEntity(this);

    public final StringPath contents = createString("contents");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    public final org.meetpl.recodingserver.domain.reviewee.domain.QReviewee reviewee;

    public final ListPath<ReviewSkill, QReviewSkill> skills = this.<ReviewSkill, QReviewSkill>createList("skills", ReviewSkill.class, QReviewSkill.class, PathInits.DIRECT2);

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reviewee = inits.isInitialized("reviewee") ? new org.meetpl.recodingserver.domain.reviewee.domain.QReviewee(forProperty("reviewee"), inits.get("reviewee")) : null;
    }

}

