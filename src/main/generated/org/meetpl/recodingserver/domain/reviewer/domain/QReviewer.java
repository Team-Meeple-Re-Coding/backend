package org.meetpl.recodingserver.domain.reviewer.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewer is a Querydsl query type for Reviewer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewer extends EntityPathBase<Reviewer> {

    private static final long serialVersionUID = 2097662019L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewer reviewer = new QReviewer("reviewer");

    public final org.meetpl.recodingserver.global.common.QBaseTimeEntity _super = new org.meetpl.recodingserver.global.common.QBaseTimeEntity(this);

    public final StringPath careerInfo = createString("careerInfo");

    public final NumberPath<Integer> careerYear = createNumber("careerYear", Integer.class);

    public final ListPath<org.meetpl.recodingserver.domain.codereview.domain.CodeReview, org.meetpl.recodingserver.domain.codereview.domain.QCodeReview> codeReviews = this.<org.meetpl.recodingserver.domain.codereview.domain.CodeReview, org.meetpl.recodingserver.domain.codereview.domain.QCodeReview>createList("codeReviews", org.meetpl.recodingserver.domain.codereview.domain.CodeReview.class, org.meetpl.recodingserver.domain.codereview.domain.QCodeReview.class, PathInits.DIRECT2);

    public final StringPath codeStyle = createString("codeStyle");

    public final StringPath corporation = createString("corporation");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final StringPath githubLink = createString("githubLink");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath intro = createString("intro");

    public final EnumPath<Job> job = createEnum("job", Job.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final org.meetpl.recodingserver.domain.member.domain.QMember member;

    public final ListPath<Skill, QSkill> skills = this.<Skill, QSkill>createList("skills", Skill.class, QSkill.class, PathInits.DIRECT2);

    public QReviewer(String variable) {
        this(Reviewer.class, forVariable(variable), INITS);
    }

    public QReviewer(Path<? extends Reviewer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewer(PathMetadata metadata, PathInits inits) {
        this(Reviewer.class, metadata, inits);
    }

    public QReviewer(Class<? extends Reviewer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new org.meetpl.recodingserver.domain.member.domain.QMember(forProperty("member")) : null;
    }

}

