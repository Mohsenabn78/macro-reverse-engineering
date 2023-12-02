package com.google.firebase.crashlytics;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: FirebaseAccess.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes5.dex */
public final class FirebaseAccess {
    public static final int $stable = 0;
    @NotNull
    public static final FirebaseAccess INSTANCE = new FirebaseAccess();

    private FirebaseAccess() {
    }

    public final void logFatalException(@NotNull Throwable e4) {
        Intrinsics.checkNotNullParameter(e4, "e");
        FirebaseCrashlytics.getInstance().f29351a.logFatalException(e4);
    }
}
