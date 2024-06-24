package org.meetpl.recodingserver.domain.codereview.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewSkill is a Querydsl query type for ReviewSkill
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewSkill extends EntityPathBase<ReviewSkill> {

    private static final long serialVersionUID = -2136627045L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewSkill reviewSkill = new QReviewSkill("reviewSkill");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final org.meetpl.recodingserver.domain.reviewer.domain.QReviewer reviewer;

    public final EnumPath<SkillType> skillType = createEnum("skillType", SkillType.class);

    public QReviewSkill(String variable) {
        this(ReviewSkill.class, forVariable(variable), INITS);
    }

    public QReviewSkill(Path<? extends ReviewSkill> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewSkill(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewSkill(PathMetadata metadata, PathInits inits) {
        this(ReviewSkill.class, metadata, inits);
    }

    public QReviewSkill(Class<? extends ReviewSkill> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reviewer = inits.isInitialized("reviewer") ? new org.meetpl.recodingserver.domain.reviewer.domain.QReviewer(forProperty("reviewer"), inits.get("reviewer")) : null;
    }

}

