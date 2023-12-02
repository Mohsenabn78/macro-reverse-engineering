package com.google.firebase.sessions;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SessionEvent.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0080\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b2\u00103J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003JE\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/google/firebase/sessions/SessionInfo;", "", "", "component1", "component2", "", "component3", "", "component4", "Lcom/google/firebase/sessions/DataCollectionStatus;", "component5", "component6", "sessionId", "firstSessionId", "sessionIndex", "eventTimestampUs", "dataCollectionStatus", "firebaseInstallationId", "copy", "toString", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "b", "getFirstSessionId", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "I", "getSessionIndex", "()I", "d", "J", "getEventTimestampUs", "()J", "setEventTimestampUs", "(J)V", "e", "Lcom/google/firebase/sessions/DataCollectionStatus;", "getDataCollectionStatus", "()Lcom/google/firebase/sessions/DataCollectionStatus;", "setDataCollectionStatus", "(Lcom/google/firebase/sessions/DataCollectionStatus;)V", "f", "getFirebaseInstallationId", "setFirebaseInstallationId", "(Ljava/lang/String;)V", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Ljava/lang/String;IJLcom/google/firebase/sessions/DataCollectionStatus;Ljava/lang/String;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class SessionInfo {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f32130a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f32131b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32132c;

    /* renamed from: d  reason: collision with root package name */
    private long f32133d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private DataCollectionStatus f32134e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private String f32135f;

    public SessionInfo(@NotNull String sessionId, @NotNull String firstSessionId, int i4, long j4, @NotNull DataCollectionStatus dataCollectionStatus, @NotNull String firebaseInstallationId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(firstSessionId, "firstSessionId");
        Intrinsics.checkNotNullParameter(dataCollectionStatus, "dataCollectionStatus");
        Intrinsics.checkNotNullParameter(firebaseInstallationId, "firebaseInstallationId");
        this.f32130a = sessionId;
        this.f32131b = firstSessionId;
        this.f32132c = i4;
        this.f32133d = j4;
        this.f32134e = dataCollectionStatus;
        this.f32135f = firebaseInstallationId;
    }

    public static /* synthetic */ SessionInfo copy$default(SessionInfo sessionInfo, String str, String str2, int i4, long j4, DataCollectionStatus dataCollectionStatus, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = sessionInfo.f32130a;
        }
        if ((i5 & 2) != 0) {
            str2 = sessionInfo.f32131b;
        }
        String str4 = str2;
        if ((i5 & 4) != 0) {
            i4 = sessionInfo.f32132c;
        }
        int i6 = i4;
        if ((i5 & 8) != 0) {
            j4 = sessionInfo.f32133d;
        }
        long j5 = j4;
        if ((i5 & 16) != 0) {
            dataCollectionStatus = sessionInfo.f32134e;
        }
        DataCollectionStatus dataCollectionStatus2 = dataCollectionStatus;
        if ((i5 & 32) != 0) {
            str3 = sessionInfo.f32135f;
        }
        return sessionInfo.copy(str, str4, i6, j5, dataCollectionStatus2, str3);
    }

    @NotNull
    public final String component1() {
        return this.f32130a;
    }

    @NotNull
    public final String component2() {
        return this.f32131b;
    }

    public final int component3() {
        return this.f32132c;
    }

    public final long component4() {
        return this.f32133d;
    }

    @NotNull
    public final DataCollectionStatus component5() {
        return this.f32134e;
    }

    @NotNull
    public final String component6() {
        return this.f32135f;
    }

    @NotNull
    public final SessionInfo copy(@NotNull String sessionId, @NotNull String firstSessionId, int i4, long j4, @NotNull DataCollectionStatus dataCollectionStatus, @NotNull String firebaseInstallationId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(firstSessionId, "firstSessionId");
        Intrinsics.checkNotNullParameter(dataCollectionStatus, "dataCollectionStatus");
        Intrinsics.checkNotNullParameter(firebaseInstallationId, "firebaseInstallationId");
        return new SessionInfo(sessionId, firstSessionId, i4, j4, dataCollectionStatus, firebaseInstallationId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) obj;
        if (Intrinsics.areEqual(this.f32130a, sessionInfo.f32130a) && Intrinsics.areEqual(this.f32131b, sessionInfo.f32131b) && this.f32132c == sessionInfo.f32132c && this.f32133d == sessionInfo.f32133d && Intrinsics.areEqual(this.f32134e, sessionInfo.f32134e) && Intrinsics.areEqual(this.f32135f, sessionInfo.f32135f)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final DataCollectionStatus getDataCollectionStatus() {
        return this.f32134e;
    }

    public final long getEventTimestampUs() {
        return this.f32133d;
    }

    @NotNull
    public final String getFirebaseInstallationId() {
        return this.f32135f;
    }

    @NotNull
    public final String getFirstSessionId() {
        return this.f32131b;
    }

    @NotNull
    public final String getSessionId() {
        return this.f32130a;
    }

    public final int getSessionIndex() {
        return this.f32132c;
    }

    public int hashCode() {
        return (((((((((this.f32130a.hashCode() * 31) + this.f32131b.hashCode()) * 31) + this.f32132c) * 31) + androidx.compose.animation.a.a(this.f32133d)) * 31) + this.f32134e.hashCode()) * 31) + this.f32135f.hashCode();
    }

    public final void setDataCollectionStatus(@NotNull DataCollectionStatus dataCollectionStatus) {
        Intrinsics.checkNotNullParameter(dataCollectionStatus, "<set-?>");
        this.f32134e = dataCollectionStatus;
    }

    public final void setEventTimestampUs(long j4) {
        this.f32133d = j4;
    }

    public final void setFirebaseInstallationId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f32135f = str;
    }

    @NotNull
    public String toString() {
        return "SessionInfo(sessionId=" + this.f32130a + ", firstSessionId=" + this.f32131b + ", sessionIndex=" + this.f32132c + ", eventTimestampUs=" + this.f32133d + ", dataCollectionStatus=" + this.f32134e + ", firebaseInstallationId=" + this.f32135f + ')';
    }

    public /* synthetic */ SessionInfo(String str, String str2, int i4, long j4, DataCollectionStatus dataCollectionStatus, String str3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i4, j4, (i5 & 16) != 0 ? new DataCollectionStatus(null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 7, null) : dataCollectionStatus, (i5 & 32) != 0 ? "" : str3);
    }
}
