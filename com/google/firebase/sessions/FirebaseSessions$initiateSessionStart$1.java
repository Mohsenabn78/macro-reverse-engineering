package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FirebaseSessions.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.FirebaseSessions", f = "FirebaseSessions.kt", i = {0, 0, 1, 1, 1}, l = {111, 134, 149}, m = "initiateSessionStart", n = {"this", "sessionDetails", "this", "sessionDetails", "subscribers"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
public final class FirebaseSessions$initiateSessionStart$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FirebaseSessions this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseSessions$initiateSessionStart$1(FirebaseSessions firebaseSessions, Continuation<? super FirebaseSessions$initiateSessionStart$1> continuation) {
        super(continuation);
        this.this$0 = firebaseSessions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object c4;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        c4 = this.this$0.c(null, this);
        return c4;
    }
}
