package com.google.firebase.sessions;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.firebase.encoders.annotations.Encodable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SessionEvent.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/google/firebase/sessions/SessionEvent;", "", "Lcom/google/firebase/sessions/EventType;", "component1", "Lcom/google/firebase/sessions/SessionInfo;", "component2", "Lcom/google/firebase/sessions/ApplicationInfo;", "component3", "eventType", "sessionData", "applicationInfo", "copy", "", "toString", "", "hashCode", "other", "", "equals", "a", "Lcom/google/firebase/sessions/EventType;", "getEventType", "()Lcom/google/firebase/sessions/EventType;", "b", "Lcom/google/firebase/sessions/SessionInfo;", "getSessionData", "()Lcom/google/firebase/sessions/SessionInfo;", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "Lcom/google/firebase/sessions/ApplicationInfo;", "getApplicationInfo", "()Lcom/google/firebase/sessions/ApplicationInfo;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/google/firebase/sessions/EventType;Lcom/google/firebase/sessions/SessionInfo;Lcom/google/firebase/sessions/ApplicationInfo;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
@Encodable
/* loaded from: classes5.dex */
public final class SessionEvent {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final EventType f32119a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SessionInfo f32120b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ApplicationInfo f32121c;

    public SessionEvent(@NotNull EventType eventType, @NotNull SessionInfo sessionData, @NotNull ApplicationInfo applicationInfo) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
        this.f32119a = eventType;
        this.f32120b = sessionData;
        this.f32121c = applicationInfo;
    }

    public static /* synthetic */ SessionEvent copy$default(SessionEvent sessionEvent, EventType eventType, SessionInfo sessionInfo, ApplicationInfo applicationInfo, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            eventType = sessionEvent.f32119a;
        }
        if ((i4 & 2) != 0) {
            sessionInfo = sessionEvent.f32120b;
        }
        if ((i4 & 4) != 0) {
            applicationInfo = sessionEvent.f32121c;
        }
        return sessionEvent.copy(eventType, sessionInfo, applicationInfo);
    }

    @NotNull
    public final EventType component1() {
        return this.f32119a;
    }

    @NotNull
    public final SessionInfo component2() {
        return this.f32120b;
    }

    @NotNull
    public final ApplicationInfo component3() {
        return this.f32121c;
    }

    @NotNull
    public final SessionEvent copy(@NotNull EventType eventType, @NotNull SessionInfo sessionData, @NotNull ApplicationInfo applicationInfo) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
        return new SessionEvent(eventType, sessionData, applicationInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionEvent)) {
            return false;
        }
        SessionEvent sessionEvent = (SessionEvent) obj;
        if (this.f32119a == sessionEvent.f32119a && Intrinsics.areEqual(this.f32120b, sessionEvent.f32120b) && Intrinsics.areEqual(this.f32121c, sessionEvent.f32121c)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ApplicationInfo getApplicationInfo() {
        return this.f32121c;
    }

    @NotNull
    public final EventType getEventType() {
        return this.f32119a;
    }

    @NotNull
    public final SessionInfo getSessionData() {
        return this.f32120b;
    }

    public int hashCode() {
        return (((this.f32119a.hashCode() * 31) + this.f32120b.hashCode()) * 31) + this.f32121c.hashCode();
    }

    @NotNull
    public String toString() {
        return "SessionEvent(eventType=" + this.f32119a + ", sessionData=" + this.f32120b + ", applicationInfo=" + this.f32121c + ')';
    }
}
