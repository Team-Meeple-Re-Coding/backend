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

    public final org.meetpl.recodingserver.domain.codereview.domain.QCodeReview codeReview;

    public final StringPath codeStyle = createString("codeStyle");

    public final StringPath corporation = createString("corporation");

    public final DatePath<java.time.LocalDate> enterDate = createDate("enterDate", java.time.LocalDate.class);

    public final StringPath githubLink = createString("githubLink");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath intro = createString("intro");

    public final EnumPath<Job> job = createEnum("job", Job.class);

    public final org.meetpl.recodingserver.domain.member.domain.QMember member;

    public final NumberPath<Integer> reviewContentCount = createNumber("reviewContentCount", Integer.class);

    public final NumberPath<Integer> reviewCount = createNumber("reviewCount", Integer.class);

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
        this.codeReview = inits.isInitialized("codeReview") ? new org.meetpl.recodingserver.domain.codereview.domain.QCodeReview(forProperty("codeReview"), inits.get("codeReview")) : null;
        this.member = inits.isInitialized("member") ? new org.meetpl.recodingserver.domain.member.domain.QMember(forProperty("member")) : null;
    }

}

