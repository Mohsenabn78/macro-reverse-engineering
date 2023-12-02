package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Preconditions;
import com.google.protobuf.ByteString;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class TargetData {

    /* renamed from: a  reason: collision with root package name */
    private final Target f30768a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30769b;

    /* renamed from: c  reason: collision with root package name */
    private final long f30770c;

    /* renamed from: d  reason: collision with root package name */
    private final QueryPurpose f30771d;

    /* renamed from: e  reason: collision with root package name */
    private final SnapshotVersion f30772e;

    /* renamed from: f  reason: collision with root package name */
    private final SnapshotVersion f30773f;

    /* renamed from: g  reason: collision with root package name */
    private final ByteString f30774g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Integer f30775h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TargetData(Target target, int i4, long j4, QueryPurpose queryPurpose, SnapshotVersion snapshotVersion, SnapshotVersion snapshotVersion2, ByteString byteString, @Nullable Integer num) {
        this.f30768a = (Target) Preconditions.checkNotNull(target);
        this.f30769b = i4;
        this.f30770c = j4;
        this.f30773f = snapshotVersion2;
        this.f30771d = queryPurpose;
        this.f30772e = (SnapshotVersion) Preconditions.checkNotNull(snapshotVersion);
        this.f30774g = (ByteString) Preconditions.checkNotNull(byteString);
        this.f30775h = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TargetData.class != obj.getClass()) {
            return false;
        }
        TargetData targetData = (TargetData) obj;
        if (this.f30768a.equals(targetData.f30768a) && this.f30769b == targetData.f30769b && this.f30770c == targetData.f30770c && this.f30771d.equals(targetData.f30771d) && this.f30772e.equals(targetData.f30772e) && this.f30773f.equals(targetData.f30773f) && this.f30774g.equals(targetData.f30774g) && Objects.equals(this.f30775h, targetData.f30775h)) {
            return true;
        }
        return false;
    }

    @Nullable
    public Integer getExpectedCount() {
        return this.f30775h;
    }

    public SnapshotVersion getLastLimboFreeSnapshotVersion() {
        return this.f30773f;
    }

    public QueryPurpose getPurpose() {
        return this.f30771d;
    }

    public ByteString getResumeToken() {
        return this.f30774g;
    }

    public long getSequenceNumber() {
        return this.f30770c;
    }

    public SnapshotVersion getSnapshotVersion() {
        return this.f30772e;
    }

    public Target getTarget() {
        return this.f30768a;
    }

    public int getTargetId() {
        return this.f30769b;
    }

    public int hashCode() {
        return (((((((((((((this.f30768a.hashCode() * 31) + this.f30769b) * 31) + ((int) this.f30770c)) * 31) + this.f30771d.hashCode()) * 31) + this.f30772e.hashCode()) * 31) + this.f30773f.hashCode()) * 31) + this.f30774g.hashCode()) * 31) + Objects.hashCode(this.f30775h);
    }

    public String toString() {
        return "TargetData{target=" + this.f30768a + ", targetId=" + this.f30769b + ", sequenceNumber=" + this.f30770c + ", purpose=" + this.f30771d + ", snapshotVersion=" + this.f30772e + ", lastLimboFreeSnapshotVersion=" + this.f30773f + ", resumeToken=" + this.f30774g + ", expectedCount=" + this.f30775h + '}';
    }

    public TargetData withExpectedCount(@Nullable Integer num) {
        return new TargetData(this.f30768a, this.f30769b, this.f30770c, this.f30771d, this.f30772e, this.f30773f, this.f30774g, num);
    }

    public TargetData withLastLimboFreeSnapshotVersion(SnapshotVersion snapshotVersion) {
        return new TargetData(this.f30768a, this.f30769b, this.f30770c, this.f30771d, this.f30772e, snapshotVersion, this.f30774g, this.f30775h);
    }

    public TargetData withResumeToken(ByteString byteString, SnapshotVersion snapshotVersion) {
        return new TargetData(this.f30768a, this.f30769b, this.f30770c, this.f30771d, snapshotVersion, this.f30773f, byteString, null);
    }

    public TargetData withSequenceNumber(long j4) {
        return new TargetData(this.f30768a, this.f30769b, j4, this.f30771d, this.f30772e, this.f30773f, this.f30774g, this.f30775h);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TargetData(com.google.firebase.firestore.core.Target r11, int r12, long r13, com.google.firebase.firestore.local.QueryPurpose r15) {
        /*
            r10 = this;
            com.google.firebase.firestore.model.SnapshotVersion r7 = com.google.firebase.firestore.model.SnapshotVersion.NONE
            com.google.protobuf.ByteString r8 = com.google.firebase.firestore.remote.WatchStream.EMPTY_RESUME_TOKEN
            r9 = 0
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r5 = r15
            r6 = r7
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.local.TargetData.<init>(com.google.firebase.firestore.core.Target, int, long, com.google.firebase.firestore.local.QueryPurpose):void");
    }
}
