package com.github.javiersantos.piracychecker.callbacks;

import com.github.javiersantos.piracychecker.enums.PiracyCheckerError;
import com.github.javiersantos.piracychecker.enums.PirateApp;
import com.google.firebase.messaging.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PiracyCheckerCallbacks.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017¨\u0006\t"}, d2 = {"Lcom/github/javiersantos/piracychecker/callbacks/DoNotAllowCallback;", "", "doNotAllow", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/github/javiersantos/piracychecker/enums/PiracyCheckerError;", "app", "Lcom/github/javiersantos/piracychecker/enums/PirateApp;", "dontAllow", "library_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public interface DoNotAllowCallback {

    /* compiled from: PiracyCheckerCallbacks.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        @Deprecated(message = "dontAllow has been deprecated in favor of doNotAllow", replaceWith = @ReplaceWith(expression = "doNotAllow", imports = {}))
        public static void dontAllow(DoNotAllowCallback doNotAllowCallback, @NotNull PiracyCheckerError error, @Nullable PirateApp pirateApp) {
            Intrinsics.checkParameterIsNotNull(error, "error");
            doNotAllowCallback.doNotAllow(error, pirateApp);
        }
    }

    void doNotAllow(@NotNull PiracyCheckerError piracyCheckerError, @Nullable PirateApp pirateApp);

    @Deprecated(message = "dontAllow has been deprecated in favor of doNotAllow", replaceWith = @ReplaceWith(expression = "doNotAllow", imports = {}))
    void dontAllow(@NotNull PiracyCheckerError piracyCheckerError, @Nullable PirateApp pirateApp);
}
