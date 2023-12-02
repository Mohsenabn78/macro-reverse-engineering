package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class WatchChange {

    /* loaded from: classes5.dex */
    public static final class DocumentChange extends WatchChange {

        /* renamed from: a  reason: collision with root package name */
        private final List<Integer> f31175a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Integer> f31176b;

        /* renamed from: c  reason: collision with root package name */
        private final DocumentKey f31177c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final MutableDocument f31178d;

        public DocumentChange(List<Integer> list, List<Integer> list2, DocumentKey documentKey, @Nullable MutableDocument mutableDocument) {
            super();
            this.f31175a = list;
            this.f31176b = list2;
            this.f31177c = documentKey;
            this.f31178d = mutableDocument;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || DocumentChange.class != obj.getClass()) {
                return false;
            }
            DocumentChange documentChange = (DocumentChange) obj;
            if (!this.f31175a.equals(documentChange.f31175a) || !this.f31176b.equals(documentChange.f31176b) || !this.f31177c.equals(documentChange.f31177c)) {
                return false;
            }
            MutableDocument mutableDocument = this.f31178d;
            MutableDocument mutableDocument2 = documentChange.f31178d;
            if (mutableDocument != null) {
                return mutableDocument.equals(mutableDocument2);
            }
            if (mutableDocument2 == null) {
                return true;
            }
            return false;
        }

        public DocumentKey getDocumentKey() {
            return this.f31177c;
        }

        @Nullable
        public MutableDocument getNewDocument() {
            return this.f31178d;
        }

        public List<Integer> getRemovedTargetIds() {
            return this.f31176b;
        }

        public List<Integer> getUpdatedTargetIds() {
            return this.f31175a;
        }

        public int hashCode() {
            int i4;
            int hashCode = ((((this.f31175a.hashCode() * 31) + this.f31176b.hashCode()) * 31) + this.f31177c.hashCode()) * 31;
            MutableDocument mutableDocument = this.f31178d;
            if (mutableDocument != null) {
                i4 = mutableDocument.hashCode();
            } else {
                i4 = 0;
            }
            return hashCode + i4;
        }

        public String toString() {
            return "DocumentChange{updatedTargetIds=" + this.f31175a + ", removedTargetIds=" + this.f31176b + ", key=" + this.f31177c + ", newDocument=" + this.f31178d + '}';
        }
    }

    /* loaded from: classes5.dex */
    public static final class ExistenceFilterWatchChange extends WatchChange {

        /* renamed from: a  reason: collision with root package name */
        private final int f31179a;

        /* renamed from: b  reason: collision with root package name */
        private final ExistenceFilter f31180b;

        public ExistenceFilterWatchChange(int i4, ExistenceFilter existenceFilter) {
            super();
            this.f31179a = i4;
            this.f31180b = existenceFilter;
        }

        public ExistenceFilter getExistenceFilter() {
            return this.f31180b;
        }

        public int getTargetId() {
            return this.f31179a;
        }

        public String toString() {
            return "ExistenceFilterWatchChange{targetId=" + this.f31179a + ", existenceFilter=" + this.f31180b + '}';
        }
    }

    /* loaded from: classes5.dex */
    public static final class WatchTargetChange extends WatchChange {

        /* renamed from: a  reason: collision with root package name */
        private final WatchTargetChangeType f31181a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Integer> f31182b;

        /* renamed from: c  reason: collision with root package name */
        private final ByteString f31183c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final Status f31184d;

        public WatchTargetChange(WatchTargetChangeType watchTargetChangeType, List<Integer> list) {
            this(watchTargetChangeType, list, WatchStream.EMPTY_RESUME_TOKEN, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || WatchTargetChange.class != obj.getClass()) {
                return false;
            }
            WatchTargetChange watchTargetChange = (WatchTargetChange) obj;
            if (this.f31181a != watchTargetChange.f31181a || !this.f31182b.equals(watchTargetChange.f31182b) || !this.f31183c.equals(watchTargetChange.f31183c)) {
                return false;
            }
            Status status = this.f31184d;
            if (status != null) {
                if (watchTargetChange.f31184d != null && status.getCode().equals(watchTargetChange.f31184d.getCode())) {
                    return true;
                }
                return false;
            } else if (watchTargetChange.f31184d == null) {
                return true;
            } else {
                return false;
            }
        }

        @Nullable
        public Status getCause() {
            return this.f31184d;
        }

        public WatchTargetChangeType getChangeType() {
            return this.f31181a;
        }

        public ByteString getResumeToken() {
            return this.f31183c;
        }

        public List<Integer> getTargetIds() {
            return this.f31182b;
        }

        public int hashCode() {
            int i4;
            int hashCode = ((((this.f31181a.hashCode() * 31) + this.f31182b.hashCode()) * 31) + this.f31183c.hashCode()) * 31;
            Status status = this.f31184d;
            if (status != null) {
                i4 = status.getCode().hashCode();
            } else {
                i4 = 0;
            }
            return hashCode + i4;
        }

        public String toString() {
            return "WatchTargetChange{changeType=" + this.f31181a + ", targetIds=" + this.f31182b + '}';
        }

        public WatchTargetChange(WatchTargetChangeType watchTargetChangeType, List<Integer> list, ByteString byteString) {
            this(watchTargetChangeType, list, byteString, null);
        }

        public WatchTargetChange(WatchTargetChangeType watchTargetChangeType, List<Integer> list, ByteString byteString, @Nullable Status status) {
            super();
            Assert.hardAssert(status == null || watchTargetChangeType == WatchTargetChangeType.Removed, "Got cause for a target change that was not a removal", new Object[0]);
            this.f31181a = watchTargetChangeType;
            this.f31182b = list;
            this.f31183c = byteString;
            if (status != null && !status.isOk()) {
                this.f31184d = status;
            } else {
                this.f31184d = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum WatchTargetChangeType {
        NoChange,
        Added,
        Removed,
        Current,
        Reset
    }

    private WatchChange() {
    }
}
