package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionCoordinator.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.SessionCoordinator", f = "SessionCoordinator.kt", i = {0, 0}, l = {36}, m = "attemptLoggingSessionEvent", n = {"this", "sessionEvent"}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
public final class SessionCoordinator$attemptLoggingSessionEvent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionCoordinator$attemptLoggingSessionEvent$1(SessionCoordinator sessionCoordinator, Continuation<? super SessionCoordinator$attemptLoggingSessionEvent$1> continuation) {
        super(continuation);
        this.this$0 = sessionCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.attemptLoggingSessionEvent(null, this);
    }
}
