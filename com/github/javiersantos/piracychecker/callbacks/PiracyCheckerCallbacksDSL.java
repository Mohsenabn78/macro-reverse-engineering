package com.github.javiersantos.piracychecker.callbacks;

import com.github.javiersantos.piracychecker.PiracyChecker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

/* compiled from: PiracyCheckerCallbacksDSL.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/github/javiersantos/piracychecker/callbacks/PiracyCheckerCallbacksDSL;", "", "Lcom/github/javiersantos/piracychecker/callbacks/AllowCallback;", "allowCallback", "Lcom/github/javiersantos/piracychecker/PiracyChecker;", "allow", "Lcom/github/javiersantos/piracychecker/callbacks/DoNotAllowCallback;", "doNotAllowCallback", "doNotAllow", "Lcom/github/javiersantos/piracychecker/callbacks/OnErrorCallback;", "onErrorCallback", "onError", "a", "Lcom/github/javiersantos/piracychecker/PiracyChecker;", "checker", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/github/javiersantos/piracychecker/PiracyChecker;)V", "library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class PiracyCheckerCallbacksDSL {

    /* renamed from: a  reason: collision with root package name */
    private final PiracyChecker f18453a;

    public PiracyCheckerCallbacksDSL(@NotNull PiracyChecker checker) {
        Intrinsics.checkParameterIsNotNull(checker, "checker");
        this.f18453a = checker;
    }

    @NotNull
    public final PiracyChecker allow(@NotNull AllowCallback allowCallback) {
        Intrinsics.checkParameterIsNotNull(allowCallback, "allowCallback");
        return this.f18453a.allowCallback(allowCallback);
    }

    @NotNull
    public final PiracyChecker doNotAllow(@NotNull DoNotAllowCallback doNotAllowCallback) {
        Intrinsics.checkParameterIsNotNull(doNotAllowCallback, "doNotAllowCallback");
        return this.f18453a.doNotAllowCallback(doNotAllowCallback);
    }

    @NotNull
    public final PiracyChecker onError(@NotNull OnErrorCallback onErrorCallback) {
        Intrinsics.checkParameterIsNotNull(onErrorCallback, "onErrorCallback");
        return this.f18453a.onErrorCallback(onErrorCallback);
    }
}
