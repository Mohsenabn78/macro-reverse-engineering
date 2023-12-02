package com.google.firebase.firestore.model;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.FieldIndex;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@AutoValue
/* loaded from: classes5.dex */
public abstract class FieldIndex {
    public static final int INITIAL_LARGEST_BATCH_ID = -1;
    public static final int INITIAL_SEQUENCE_NUMBER = 0;
    public static IndexState INITIAL_STATE = IndexState.create(0, IndexOffset.NONE);
    public static final Comparator<FieldIndex> SEMANTIC_COMPARATOR = new Comparator() { // from class: com.google.firebase.firestore.model.e
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int b4;
            b4 = FieldIndex.b((FieldIndex) obj, (FieldIndex) obj2);
            return b4;
        }
    };
    public static final int UNKNOWN_ID = -1;

    @AutoValue
    /* loaded from: classes5.dex */
    public static abstract class IndexOffset implements Comparable<IndexOffset> {
        public static final IndexOffset NONE = create(SnapshotVersion.NONE, DocumentKey.empty(), -1);
        public static final Comparator<MutableDocument> DOCUMENT_COMPARATOR = new Comparator() { // from class: com.google.firebase.firestore.model.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b4;
                b4 = FieldIndex.IndexOffset.b((MutableDocument) obj, (MutableDocument) obj2);
                return b4;
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int b(MutableDocument mutableDocument, MutableDocument mutableDocument2) {
            return fromDocument(mutableDocument).compareTo(fromDocument(mutableDocument2));
        }

        public static IndexOffset create(SnapshotVersion snapshotVersion, DocumentKey documentKey, int i4) {
            return new AutoValue_FieldIndex_IndexOffset(snapshotVersion, documentKey, i4);
        }

        public static IndexOffset createSuccessor(SnapshotVersion snapshotVersion, int i4) {
            Timestamp timestamp;
            long seconds = snapshotVersion.getTimestamp().getSeconds();
            int nanoseconds = snapshotVersion.getTimestamp().getNanoseconds() + 1;
            if (nanoseconds == 1.0E9d) {
                timestamp = new Timestamp(seconds + 1, 0);
            } else {
                timestamp = new Timestamp(seconds, nanoseconds);
            }
            return create(new SnapshotVersion(timestamp), DocumentKey.empty(), i4);
        }

        public static IndexOffset fromDocument(Document document) {
            return create(document.getReadTime(), document.getKey(), -1);
        }

        public abstract DocumentKey getDocumentKey();

        public abstract int getLargestBatchId();

        public abstract SnapshotVersion getReadTime();

        @Override // java.lang.Comparable
        public int compareTo(IndexOffset indexOffset) {
            int compareTo = getReadTime().compareTo(indexOffset.getReadTime());
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = getDocumentKey().compareTo(indexOffset.getDocumentKey());
            return compareTo2 != 0 ? compareTo2 : Integer.compare(getLargestBatchId(), indexOffset.getLargestBatchId());
        }
    }

    @AutoValue
    /* loaded from: classes5.dex */
    public static abstract class IndexState {
        public static IndexState create(long j4, IndexOffset indexOffset) {
            return new AutoValue_FieldIndex_IndexState(j4, indexOffset);
        }

        public abstract IndexOffset getOffset();

        public abstract long getSequenceNumber();

        public static IndexState create(long j4, SnapshotVersion snapshotVersion, DocumentKey documentKey, int i4) {
            return create(j4, IndexOffset.create(snapshotVersion, documentKey, i4));
        }
    }

    @AutoValue
    /* loaded from: classes5.dex */
    public static abstract class Segment implements Comparable<Segment> {

        /* loaded from: classes5.dex */
        public enum Kind {
            ASCENDING,
            DESCENDING,
            CONTAINS
        }

        public static Segment create(FieldPath fieldPath, Kind kind) {
            return new AutoValue_FieldIndex_Segment(fieldPath, kind);
        }

        public abstract FieldPath getFieldPath();

        public abstract Kind getKind();

        @Override // java.lang.Comparable
        public int compareTo(Segment segment) {
            int compareTo = getFieldPath().compareTo(segment.getFieldPath());
            return compareTo != 0 ? compareTo : getKind().compareTo(segment.getKind());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(FieldIndex fieldIndex, FieldIndex fieldIndex2) {
        int compareTo = fieldIndex.getCollectionGroup().compareTo(fieldIndex2.getCollectionGroup());
        if (compareTo != 0) {
            return compareTo;
        }
        Iterator<Segment> it = fieldIndex.getSegments().iterator();
        Iterator<Segment> it2 = fieldIndex2.getSegments().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compareTo2 = it.next().compareTo(it2.next());
            if (compareTo2 != 0) {
                return compareTo2;
            }
        }
        return Boolean.compare(it.hasNext(), it2.hasNext());
    }

    public static FieldIndex create(int i4, String str, List<Segment> list, IndexState indexState) {
        return new AutoValue_FieldIndex(i4, str, list, indexState);
    }

    @Nullable
    public Segment getArraySegment() {
        for (Segment segment : getSegments()) {
            if (segment.getKind().equals(Segment.Kind.CONTAINS)) {
                return segment;
            }
        }
        return null;
    }

    public abstract String getCollectionGroup();

    public List<Segment> getDirectionalSegments() {
        ArrayList arrayList = new ArrayList();
        for (Segment segment : getSegments()) {
            if (!segment.getKind().equals(Segment.Kind.CONTAINS)) {
                arrayList.add(segment);
            }
        }
        return arrayList;
    }

    public abstract int getIndexId();

    public abstract IndexState getIndexState();

    public abstract List<Segment> getSegments();
}
