package com.google.firebase.auth.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzv extends FirebaseAuth {
    public zzv(FirebaseApp firebaseApp, Provider provider, Provider provider2, @Background Executor executor, @Blocking Executor executor2, @Lightweight Executor executor3, @Lightweight ScheduledExecutorService scheduledExecutorService, @UiThread Executor executor4) {
        super(firebaseApp, provider, provider2, executor, executor2, executor3, scheduledExecutorService, executor4);
    }
}
