package com.google.firebase.firestore.local;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.bundle.BundledQuery;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.firebase.firestore.proto.NoDocument;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.proto.UnknownDocument;
import com.google.firebase.firestore.proto.WriteBatch;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.bundle.BundledQuery;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentTransform;
import com.google.firestore.v1.Target;
import com.google.firestore.v1.Write;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class LocalSerializer {

    /* renamed from: a  reason: collision with root package name */
    private final RemoteSerializer f30602a;

    /* renamed from: com.google.firebase.firestore.local.LocalSerializer$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30603a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f30604b;

        static {
            int[] iArr = new int[Target.TargetTypeCase.values().length];
            f30604b = iArr;
            try {
                iArr[Target.TargetTypeCase.DOCUMENTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30604b[Target.TargetTypeCase.QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[MaybeDocument.DocumentTypeCase.values().length];
            f30603a = iArr2;
            try {
                iArr2[MaybeDocument.DocumentTypeCase.DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30603a[MaybeDocument.DocumentTypeCase.NO_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30603a[MaybeDocument.DocumentTypeCase.UNKNOWN_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public LocalSerializer(RemoteSerializer remoteSerializer) {
        this.f30602a = remoteSerializer;
    }

    private MutableDocument a(Document document, boolean z3) {
        MutableDocument newFoundDocument = MutableDocument.newFoundDocument(this.f30602a.decodeKey(document.getName()), this.f30602a.decodeVersion(document.getUpdateTime()), ObjectValue.fromMap(document.getFieldsMap()));
        if (z3) {
            return newFoundDocument.setHasCommittedMutations();
        }
        return newFoundDocument;
    }

    private MutableDocument d(NoDocument noDocument, boolean z3) {
        MutableDocument newNoDocument = MutableDocument.newNoDocument(this.f30602a.decodeKey(noDocument.getName()), this.f30602a.decodeVersion(noDocument.getReadTime()));
        if (z3) {
            return newNoDocument.setHasCommittedMutations();
        }
        return newNoDocument;
    }

    private MutableDocument f(UnknownDocument unknownDocument) {
        return MutableDocument.newUnknownDocument(this.f30602a.decodeKey(unknownDocument.getName()), this.f30602a.decodeVersion(unknownDocument.getVersion()));
    }

    private Document g(com.google.firebase.firestore.model.Document document) {
        Document.Builder newBuilder = Document.newBuilder();
        newBuilder.setName(this.f30602a.encodeKey(document.getKey()));
        newBuilder.putAllFields(document.getData().getFieldsMap());
        newBuilder.setUpdateTime(this.f30602a.encodeTimestamp(document.getVersion().getTimestamp()));
        return newBuilder.build();
    }

    private NoDocument j(com.google.firebase.firestore.model.Document document) {
        NoDocument.Builder newBuilder = NoDocument.newBuilder();
        newBuilder.setName(this.f30602a.encodeKey(document.getKey()));
        newBuilder.setReadTime(this.f30602a.encodeTimestamp(document.getVersion().getTimestamp()));
        return newBuilder.build();
    }

    private UnknownDocument l(com.google.firebase.firestore.model.Document document) {
        UnknownDocument.Builder newBuilder = UnknownDocument.newBuilder();
        newBuilder.setName(this.f30602a.encodeKey(document.getKey()));
        newBuilder.setVersion(this.f30602a.encodeTimestamp(document.getVersion().getTimestamp()));
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableDocument b(MaybeDocument maybeDocument) {
        int i4 = AnonymousClass1.f30603a[maybeDocument.getDocumentTypeCase().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return f(maybeDocument.getUnknownDocument());
                }
                throw Assert.fail("Unknown MaybeDocument %s", maybeDocument);
            }
            return d(maybeDocument.getNoDocument(), maybeDocument.getHasCommittedMutations());
        }
        return a(maybeDocument.getDocument(), maybeDocument.getHasCommittedMutations());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutationBatch c(WriteBatch writeBatch) {
        boolean z3;
        int batchId = writeBatch.getBatchId();
        Timestamp decodeTimestamp = this.f30602a.decodeTimestamp(writeBatch.getLocalWriteTime());
        int baseWritesCount = writeBatch.getBaseWritesCount();
        ArrayList arrayList = new ArrayList(baseWritesCount);
        for (int i4 = 0; i4 < baseWritesCount; i4++) {
            arrayList.add(this.f30602a.decodeMutation(writeBatch.getBaseWrites(i4)));
        }
        ArrayList arrayList2 = new ArrayList(writeBatch.getWritesCount());
        int i5 = 0;
        while (i5 < writeBatch.getWritesCount()) {
            Write writes = writeBatch.getWrites(i5);
            int i6 = i5 + 1;
            if (i6 < writeBatch.getWritesCount() && writeBatch.getWrites(i6).hasTransform()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                Assert.hardAssert(writeBatch.getWrites(i5).hasUpdate(), "TransformMutation should be preceded by a patch or set mutation", new Object[0]);
                Write.Builder newBuilder = Write.newBuilder(writes);
                for (DocumentTransform.FieldTransform fieldTransform : writeBatch.getWrites(i6).getTransform().getFieldTransformsList()) {
                    newBuilder.addUpdateTransforms(fieldTransform);
                }
                arrayList2.add(this.f30602a.decodeMutation(newBuilder.build()));
                i5 = i6;
            } else {
                arrayList2.add(this.f30602a.decodeMutation(writes));
            }
            i5++;
        }
        return new MutationBatch(batchId, decodeTimestamp, arrayList, arrayList2);
    }

    public BundledQuery decodeBundledQuery(com.google.firestore.bundle.BundledQuery bundledQuery) {
        Query.LimitType limitType;
        if (bundledQuery.getLimitType().equals(BundledQuery.LimitType.FIRST)) {
            limitType = Query.LimitType.LIMIT_TO_FIRST;
        } else {
            limitType = Query.LimitType.LIMIT_TO_LAST;
        }
        return new com.google.firebase.firestore.bundle.BundledQuery(this.f30602a.decodeQueryTarget(bundledQuery.getParent(), bundledQuery.getStructuredQuery()), limitType);
    }

    public List<FieldIndex.Segment> decodeFieldIndexSegments(Index index) {
        FieldIndex.Segment.Kind kind;
        ArrayList arrayList = new ArrayList();
        for (Index.IndexField indexField : index.getFieldsList()) {
            FieldPath fromServerFormat = FieldPath.fromServerFormat(indexField.getFieldPath());
            if (indexField.getValueModeCase().equals(Index.IndexField.ValueModeCase.ARRAY_CONFIG)) {
                kind = FieldIndex.Segment.Kind.CONTAINS;
            } else if (indexField.getOrder().equals(Index.IndexField.Order.ASCENDING)) {
                kind = FieldIndex.Segment.Kind.ASCENDING;
            } else {
                kind = FieldIndex.Segment.Kind.DESCENDING;
            }
            arrayList.add(FieldIndex.Segment.create(fromServerFormat, kind));
        }
        return arrayList;
    }

    public Mutation decodeMutation(Write write) {
        return this.f30602a.decodeMutation(write);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TargetData e(Target target) {
        com.google.firebase.firestore.core.Target decodeDocumentsTarget;
        int targetId = target.getTargetId();
        SnapshotVersion decodeVersion = this.f30602a.decodeVersion(target.getSnapshotVersion());
        SnapshotVersion decodeVersion2 = this.f30602a.decodeVersion(target.getLastLimboFreeSnapshotVersion());
        ByteString resumeToken = target.getResumeToken();
        long lastListenSequenceNumber = target.getLastListenSequenceNumber();
        int i4 = AnonymousClass1.f30604b[target.getTargetTypeCase().ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                decodeDocumentsTarget = this.f30602a.decodeQueryTarget(target.getQuery());
            } else {
                throw Assert.fail("Unknown targetType %d", target.getTargetTypeCase());
            }
        } else {
            decodeDocumentsTarget = this.f30602a.decodeDocumentsTarget(target.getDocuments());
        }
        return new TargetData(decodeDocumentsTarget, targetId, lastListenSequenceNumber, QueryPurpose.LISTEN, decodeVersion, decodeVersion2, resumeToken, null);
    }

    public com.google.firestore.bundle.BundledQuery encodeBundledQuery(com.google.firebase.firestore.bundle.BundledQuery bundledQuery) {
        BundledQuery.LimitType limitType;
        Target.QueryTarget encodeQueryTarget = this.f30602a.encodeQueryTarget(bundledQuery.getTarget());
        BundledQuery.Builder newBuilder = com.google.firestore.bundle.BundledQuery.newBuilder();
        if (bundledQuery.getLimitType().equals(Query.LimitType.LIMIT_TO_FIRST)) {
            limitType = BundledQuery.LimitType.FIRST;
        } else {
            limitType = BundledQuery.LimitType.LAST;
        }
        newBuilder.setLimitType(limitType);
        newBuilder.setParent(encodeQueryTarget.getParent());
        newBuilder.setStructuredQuery(encodeQueryTarget.getStructuredQuery());
        return newBuilder.build();
    }

    public Index encodeFieldIndexSegments(List<FieldIndex.Segment> list) {
        Index.Builder newBuilder = Index.newBuilder();
        newBuilder.setQueryScope(Index.QueryScope.COLLECTION_GROUP);
        for (FieldIndex.Segment segment : list) {
            Index.IndexField.Builder newBuilder2 = Index.IndexField.newBuilder();
            newBuilder2.setFieldPath(segment.getFieldPath().canonicalString());
            if (segment.getKind() == FieldIndex.Segment.Kind.CONTAINS) {
                newBuilder2.setArrayConfig(Index.IndexField.ArrayConfig.CONTAINS);
            } else if (segment.getKind() == FieldIndex.Segment.Kind.ASCENDING) {
                newBuilder2.setOrder(Index.IndexField.Order.ASCENDING);
            } else {
                newBuilder2.setOrder(Index.IndexField.Order.DESCENDING);
            }
            newBuilder.addFields(newBuilder2);
        }
        return newBuilder.build();
    }

    public Write encodeMutation(Mutation mutation) {
        return this.f30602a.encodeMutation(mutation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaybeDocument h(com.google.firebase.firestore.model.Document document) {
        MaybeDocument.Builder newBuilder = MaybeDocument.newBuilder();
        if (document.isNoDocument()) {
            newBuilder.setNoDocument(j(document));
        } else if (document.isFoundDocument()) {
            newBuilder.setDocument(g(document));
        } else if (document.isUnknownDocument()) {
            newBuilder.setUnknownDocument(l(document));
        } else {
            throw Assert.fail("Cannot encode invalid document %s", document);
        }
        newBuilder.setHasCommittedMutations(document.hasCommittedMutations());
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteBatch i(MutationBatch mutationBatch) {
        WriteBatch.Builder newBuilder = WriteBatch.newBuilder();
        newBuilder.setBatchId(mutationBatch.getBatchId());
        newBuilder.setLocalWriteTime(this.f30602a.encodeTimestamp(mutationBatch.getLocalWriteTime()));
        for (Mutation mutation : mutationBatch.getBaseMutations()) {
            newBuilder.addBaseWrites(this.f30602a.encodeMutation(mutation));
        }
        for (Mutation mutation2 : mutationBatch.getMutations()) {
            newBuilder.addWrites(this.f30602a.encodeMutation(mutation2));
        }
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.firebase.firestore.proto.Target k(TargetData targetData) {
        QueryPurpose queryPurpose = QueryPurpose.LISTEN;
        Assert.hardAssert(queryPurpose.equals(targetData.getPurpose()), "Only queries with purpose %s may be stored, got %s", queryPurpose, targetData.getPurpose());
        Target.Builder newBuilder = com.google.firebase.firestore.proto.Target.newBuilder();
        newBuilder.setTargetId(targetData.getTargetId()).setLastListenSequenceNumber(targetData.getSequenceNumber()).setLastLimboFreeSnapshotVersion(this.f30602a.encodeVersion(targetData.getLastLimboFreeSnapshotVersion())).setSnapshotVersion(this.f30602a.encodeVersion(targetData.getSnapshotVersion())).setResumeToken(targetData.getResumeToken());
        com.google.firebase.firestore.core.Target target = targetData.getTarget();
        if (target.isDocumentQuery()) {
            newBuilder.setDocuments(this.f30602a.encodeDocumentsTarget(target));
        } else {
            newBuilder.setQuery(this.f30602a.encodeQueryTarget(target));
        }
        return newBuilder.build();
    }
}
