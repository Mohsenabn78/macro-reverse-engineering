package com.google.firebase.sessions;

import com.google.firebase.installations.FirebaseInstallationsApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

/* compiled from: SessionCoordinator.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/google/firebase/sessions/SessionCoordinator;", "", "Lcom/google/firebase/sessions/SessionEvent;", "sessionEvent", "", "attemptLoggingSessionEvent", "(Lcom/google/firebase/sessions/SessionEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "a", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallations", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "b", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "eventGDTLogger", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/EventGDTLoggerInterface;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class SessionCoordinator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstallationsApi f32113a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final EventGDTLoggerInterface f32114b;

    /* compiled from: SessionCoordinator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/sessions/SessionCoordinator$Companion;", "", "()V", "TAG", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionCoordinator(@NotNull FirebaseInstallationsApi firebaseInstallations, @NotNull EventGDTLoggerInterface eventGDTLogger) {
        Intrinsics.checkNotNullParameter(firebaseInstallations, "firebaseInstallations");
        Intrinsics.checkNotNullParameter(eventGDTLogger, "eventGDTLogger");
        this.f32113a = firebaseInstallations;
        this.f32114b = eventGDTLogger;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(9:5|6|(1:(3:9|10|11)(2:25|26))(4:27|28|29|(1:31)(1:32))|12|13|14|15|16|17))|36|6|(0)(0)|12|13|14|15|16|17|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bb, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bc, code lost:
        android.util.Log.e("SessionCoordinator", "Error logging Session Start event to DataTransport: ", r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object attemptLoggingSessionEvent(@org.jetbrains.annotations.NotNull com.google.firebase.sessions.SessionEvent r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1
            if (r0 == 0) goto L13
            r0 = r8
            com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1 r0 = (com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1 r0 = new com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "SessionCoordinator"
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r7 = r0.L$3
            com.google.firebase.sessions.SessionInfo r7 = (com.google.firebase.sessions.SessionInfo) r7
            java.lang.Object r1 = r0.L$2
            com.google.firebase.sessions.SessionInfo r1 = (com.google.firebase.sessions.SessionInfo) r1
            java.lang.Object r2 = r0.L$1
            com.google.firebase.sessions.SessionEvent r2 = (com.google.firebase.sessions.SessionEvent) r2
            java.lang.Object r0 = r0.L$0
            com.google.firebase.sessions.SessionCoordinator r0 = (com.google.firebase.sessions.SessionCoordinator) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L3b
            goto L6d
        L3b:
            r7 = move-exception
            goto L7a
        L3d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            com.google.firebase.sessions.SessionInfo r8 = r7.getSessionData()
            com.google.firebase.installations.FirebaseInstallationsApi r2 = r6.f32113a     // Catch: java.lang.Exception -> L75
            com.google.android.gms.tasks.Task r2 = r2.getId()     // Catch: java.lang.Exception -> L75
            java.lang.String r5 = "firebaseInstallations.id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch: java.lang.Exception -> L75
            r0.L$0 = r6     // Catch: java.lang.Exception -> L75
            r0.L$1 = r7     // Catch: java.lang.Exception -> L75
            r0.L$2 = r8     // Catch: java.lang.Exception -> L75
            r0.L$3 = r8     // Catch: java.lang.Exception -> L75
            r0.label = r3     // Catch: java.lang.Exception -> L75
            java.lang.Object r0 = kotlinx.coroutines.tasks.TasksKt.await(r2, r0)     // Catch: java.lang.Exception -> L75
            if (r0 != r1) goto L68
            return r1
        L68:
            r2 = r7
            r7 = r8
            r1 = r7
            r8 = r0
            r0 = r6
        L6d:
            java.lang.String r3 = "{\n        firebaseInstallations.id.await()\n      }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)     // Catch: java.lang.Exception -> L3b
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L3b
            goto L96
        L75:
            r0 = move-exception
            r2 = r7
            r1 = r8
            r7 = r0
            r0 = r6
        L7a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r3 = "Error getting Firebase Installation ID: "
            r8.append(r3)
            r8.append(r7)
            java.lang.String r7 = ". Using an empty ID"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            android.util.Log.e(r4, r7)
            java.lang.String r8 = ""
            r7 = r1
        L96:
            r7.setFirebaseInstallationId(r8)
            com.google.firebase.sessions.EventGDTLoggerInterface r7 = r0.f32114b     // Catch: java.lang.RuntimeException -> Lbb
            r7.log(r2)     // Catch: java.lang.RuntimeException -> Lbb
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.RuntimeException -> Lbb
            r7.<init>()     // Catch: java.lang.RuntimeException -> Lbb
            java.lang.String r8 = "Successfully logged Session Start event: "
            r7.append(r8)     // Catch: java.lang.RuntimeException -> Lbb
            com.google.firebase.sessions.SessionInfo r8 = r2.getSessionData()     // Catch: java.lang.RuntimeException -> Lbb
            java.lang.String r8 = r8.getSessionId()     // Catch: java.lang.RuntimeException -> Lbb
            r7.append(r8)     // Catch: java.lang.RuntimeException -> Lbb
            java.lang.String r7 = r7.toString()     // Catch: java.lang.RuntimeException -> Lbb
            android.util.Log.i(r4, r7)     // Catch: java.lang.RuntimeException -> Lbb
            goto Lc1
        Lbb:
            r7 = move-exception
            java.lang.String r8 = "Error logging Session Start event to DataTransport: "
            android.util.Log.e(r4, r8, r7)
        Lc1:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionCoordinator.attemptLoggingSessionEvent(com.google.firebase.sessions.SessionEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
