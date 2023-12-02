package com.github.javiersantos.piracychecker.callbacks;

import com.github.javiersantos.piracychecker.enums.PiracyCheckerError;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: PiracyCheckerCallbacks.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/github/javiersantos/piracychecker/callbacks/OnErrorCallback;", "", "onError", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/github/javiersantos/piracychecker/enums/PiracyCheckerError;", "library_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public interface OnErrorCallback {

    /* compiled from: PiracyCheckerCallbacks.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static void onError(OnErrorCallback onErrorCallback, @NotNull PiracyCheckerError error) {
            Intrinsics.checkParameterIsNotNull(error, "error");
        }
    }

    void onError(@NotNull PiracyCheckerError piracyCheckerError);
}
