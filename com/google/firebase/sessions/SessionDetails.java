package com.google.firebase.sessions;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SessionGenerator.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J1\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/google/firebase/sessions/SessionDetails;", "", "", "component1", "component2", "", "component3", "", "component4", "sessionId", "firstSessionId", "sessionIndex", "sessionStartTimestampUs", "copy", "toString", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "b", "getFirstSessionId", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "I", "getSessionIndex", "()I", "d", "J", "getSessionStartTimestampUs", "()J", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Ljava/lang/String;IJ)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class SessionDetails {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f32115a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f32116b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32117c;

    /* renamed from: d  reason: collision with root package name */
    private final long f32118d;

    public SessionDetails(@NotNull String sessionId, @NotNull String firstSessionId, int i4, long j4) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(firstSessionId, "firstSessionId");
        this.f32115a = sessionId;
        this.f32116b = firstSessionId;
        this.f32117c = i4;
        this.f32118d = j4;
    }

    public static /* synthetic */ SessionDetails copy$default(SessionDetails sessionDetails, String str, String str2, int i4, long j4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = sessionDetails.f32115a;
        }
        if ((i5 & 2) != 0) {
            str2 = sessionDetails.f32116b;
        }
        String str3 = str2;
        if ((i5 & 4) != 0) {
            i4 = sessionDetails.f32117c;
        }
        int i6 = i4;
        if ((i5 & 8) != 0) {
            j4 = sessionDetails.f32118d;
        }
        return sessionDetails.copy(str, str3, i6, j4);
    }

    @NotNull
    public final String component1() {
        return this.f32115a;
    }

    @NotNull
    public final String component2() {
        return this.f32116b;
    }

    public final int component3() {
        return this.f32117c;
    }

    public final long component4() {
        return this.f32118d;
    }

    @NotNull
    public final SessionDetails copy(@NotNull String sessionId, @NotNull String firstSessionId, int i4, long j4) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(firstSessionId, "firstSessionId");
        return new SessionDetails(sessionId, firstSessionId, i4, j4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionDetails)) {
            return false;
        }
        SessionDetails sessionDetails = (SessionDetails) obj;
        if (Intrinsics.areEqual(this.f32115a, sessionDetails.f32115a) && Intrinsics.areEqual(this.f32116b, sessionDetails.f32116b) && this.f32117c == sessionDetails.f32117c && this.f32118d == sessionDetails.f32118d) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getFirstSessionId() {
        return this.f32116b;
    }

    @NotNull
    public final String getSessionId() {
        return this.f32115a;
    }

    public final int getSessionIndex() {
        return this.f32117c;
    }

    public final long getSessionStartTimestampUs() {
        return this.f32118d;
    }

    public int hashCode() {
        return (((((this.f32115a.hashCode() * 31) + this.f32116b.hashCode()) * 31) + this.f32117c) * 31) + androidx.compose.animation.a.a(this.f32118d);
    }

    @NotNull
    public String toString() {
        return "SessionDetails(sessionId=" + this.f32115a + ", firstSessionId=" + this.f32116b + ", sessionIndex=" + this.f32117c + ", sessionStartTimestampUs=" + this.f32118d + ')';
    }
}
