package org.meetpl.recodingserver.domain.codereview.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCodeReview is a Querydsl query type for CodeReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeReview extends EntityPathBase<CodeReview> {

    private static final long serialVersionUID = -1768694621L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCodeReview codeReview = new QCodeReview("codeReview");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath projectInfo = createString("projectInfo");

    public final StringPath request = createString("request");

    public final org.meetpl.recodingserver.domain.reviewer.domain.QReviewer reviewer;

    public QCodeReview(String variable) {
        this(CodeReview.class, forVariable(variable), INITS);
    }

    public QCodeReview(Path<? extends CodeReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCodeReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCodeReview(PathMetadata metadata, PathInits inits) {
        this(CodeReview.class, metadata, inits);
    }

    public QCodeReview(Class<? extends CodeReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reviewer = inits.isInitialized("reviewer") ? new org.meetpl.recodingserver.domain.reviewer.domain.QReviewer(forProperty("reviewer"), inits.get("reviewer")) : null;
    }

}

