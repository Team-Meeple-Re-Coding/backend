package org.meetpl.recodingserver.domain.reviewee.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewContent is a Querydsl query type for ReviewContent
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewContent extends EntityPathBase<ReviewContent> {

    private static final long serialVersionUID = 1890673776L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewContent reviewContent1 = new QReviewContent("reviewContent1");

    public final StringPath content = createString("content");

    public final NumberPath<Integer> gpa = createNumber("gpa", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QReviewContent reviewContent;

    public QReviewContent(String variable) {
        this(ReviewContent.class, forVariable(variable), INITS);
    }

    public QReviewContent(Path<? extends ReviewContent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewContent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewContent(PathMetadata metadata, PathInits inits) {
        this(ReviewContent.class, metadata, inits);
    }

    public QReviewContent(Class<? extends ReviewContent> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reviewContent = inits.isInitialized("reviewContent") ? new QReviewContent(forProperty("reviewContent"), inits.get("reviewContent")) : null;
    }

}

