package com.github.javiersantos.piracychecker.callbacks;

import com.github.javiersantos.piracychecker.callbacks.DoNotAllowCallback;
import com.github.javiersantos.piracychecker.callbacks.OnErrorCallback;
import com.github.javiersantos.piracychecker.enums.PiracyCheckerError;
import com.github.javiersantos.piracychecker.enums.PirateApp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PiracyCheckerCallbacks.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/github/javiersantos/piracychecker/callbacks/PiracyCheckerCallback;", "Lcom/github/javiersantos/piracychecker/callbacks/AllowCallback;", "Lcom/github/javiersantos/piracychecker/callbacks/DoNotAllowCallback;", "Lcom/github/javiersantos/piracychecker/callbacks/OnErrorCallback;", "()V", "library_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public abstract class PiracyCheckerCallback implements AllowCallback, DoNotAllowCallback, OnErrorCallback {
    @Override // com.github.javiersantos.piracychecker.callbacks.DoNotAllowCallback
    @Deprecated(message = "dontAllow has been deprecated in favor of doNotAllow", replaceWith = @ReplaceWith(expression = "doNotAllow", imports = {}))
    public void dontAllow(@NotNull PiracyCheckerError error, @Nullable PirateApp pirateApp) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        DoNotAllowCallback.DefaultImpls.dontAllow(this, error, pirateApp);
    }

    @Override // com.github.javiersantos.piracychecker.callbacks.OnErrorCallback
    public void onError(@NotNull PiracyCheckerError error) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        OnErrorCallback.DefaultImpls.onError(this, error);
    }
}
