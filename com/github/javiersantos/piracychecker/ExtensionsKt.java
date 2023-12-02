package com.github.javiersantos.piracychecker;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.github.javiersantos.piracychecker.callbacks.AllowCallback;
import com.github.javiersantos.piracychecker.callbacks.DoNotAllowCallback;
import com.github.javiersantos.piracychecker.callbacks.OnErrorCallback;
import com.github.javiersantos.piracychecker.callbacks.PiracyCheckerCallbacksDSL;
import com.github.javiersantos.piracychecker.enums.PiracyCheckerError;
import com.github.javiersantos.piracychecker.enums.PirateApp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Extensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u000e\b\u0006\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086\b\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\b\b\u001a+\u0010\t\u001a\u00020\u0001*\u00020\u00012\u001c\b\u0006\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\nH\u0086\b\u001a#\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0014\b\u0006\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u0006H\u0086\b\u001a#\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\b\b\u001a#\u0010\u000e\u001a\u00020\u0001*\u00020\u00112\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\b\b¨\u0006\u0012"}, d2 = {"allow", "Lcom/github/javiersantos/piracychecker/PiracyChecker;", "Lkotlin/Function0;", "", "callback", "callbacks", "Lkotlin/Function1;", "Lcom/github/javiersantos/piracychecker/callbacks/PiracyCheckerCallbacksDSL;", "Lkotlin/ExtensionFunctionType;", "doNotAllow", "Lkotlin/Function2;", "Lcom/github/javiersantos/piracychecker/enums/PiracyCheckerError;", "Lcom/github/javiersantos/piracychecker/enums/PirateApp;", "onError", "piracyChecker", "Landroid/content/Context;", "builder", "Landroidx/fragment/app/Fragment;", "library_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class ExtensionsKt {
    @NotNull
    public static final PiracyChecker allow(@NotNull PiracyChecker allow, @NotNull final Function0<Unit> allow2) {
        Intrinsics.checkParameterIsNotNull(allow, "$this$allow");
        Intrinsics.checkParameterIsNotNull(allow2, "allow");
        allow.allowCallback(new AllowCallback() { // from class: com.github.javiersantos.piracychecker.ExtensionsKt$allow$$inlined$apply$lambda$1
            @Override // com.github.javiersantos.piracychecker.callbacks.AllowCallback
            public void allow() {
                Function0.this.invoke();
            }
        });
        return allow;
    }

    public static /* synthetic */ PiracyChecker allow$default(PiracyChecker allow, final Function0 allow2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            allow2 = new Function0<Unit>() { // from class: com.github.javiersantos.piracychecker.ExtensionsKt$allow$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        Intrinsics.checkParameterIsNotNull(allow, "$this$allow");
        Intrinsics.checkParameterIsNotNull(allow2, "allow");
        allow.allowCallback(new AllowCallback() { // from class: com.github.javiersantos.piracychecker.ExtensionsKt$allow$$inlined$apply$lambda$2
            @Override // com.github.javiersantos.piracychecker.callbacks.AllowCallback
            public void allow() {
                Function0.this.invoke();
            }
        });
        return allow;
    }

    public static final void callback(@NotNull PiracyChecker callback, @NotNull Function1<? super PiracyCheckerCallbacksDSL, Unit> callbacks) {
        Intrinsics.checkParameterIsNotNull(callback, "$this$callback");
        Intrinsics.checkParameterIsNotNull(callbacks, "callbacks");
        callbacks.invoke(new PiracyCheckerCallbacksDSL(callback));
    }

    @NotNull
    public static final PiracyChecker doNotAllow(@NotNull PiracyChecker doNotAllow, @NotNull final Function2<? super PiracyCheckerError, ? super PirateApp, Unit> doNotAllow2) {
        Intrinsics.checkParameterIsNotNull(doNotAllow, "$this$doNotAllow");
        Intrinsics.checkParameterIsNotNull(doNotAllow2, "doNotAllow");
        doNotAllow.doNotAllowCallback(new DoNotAllowCallback() { // from class: com.github.javiersantos.piracychecker.ExtensionsKt$doNotAllow$$inlined$apply$lambda$1
            @Override // com.github.javiersantos.piracychecker.callbacks.DoNotAllowCallback
            public void doNotAllow(@NotNull PiracyCheckerError error, @Nullable PirateApp pirateApp) {
                Intrinsics.checkParameterIsNotNull(error, "error");
                Function2.this.mo1invoke(error, pirateApp);
            }

            @Override // com.github.javiersantos.piracychecker.callbacks.DoNotAllowCallback
            @Deprecated(message = "dontAllow has been deprecated in favor of doNotAllow", replaceWith = @ReplaceWith(expression = "doNotAllow", imports = {}))
            public void dontAllow(@NotNull PiracyCheckerError error, @Nullable PirateApp pirateApp) {
                Intrinsics.checkParameterIsNotNull(error, "error");
                DoNotAllowCallback.DefaultImpls.dontAllow(this, error, pirateApp);
            }
        });
        return doNotAllow;
    }

    public static /* synthetic */ PiracyChecker doNotAllow$default(PiracyChecker doNotAllow, final Function2 doNotAllow2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            doNotAllow2 = new Function2<PiracyCheckerError, PirateApp, Unit>() { // from class: com.github.javiersantos.piracychecker.ExtensionsKt$doNotAllow$1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ Unit mo1invoke(PiracyCheckerError piracyCheckerError, PirateApp pirateApp) {
                    invoke2(piracyCheckerError, pirateApp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PiracyCheckerError piracyCheckerError, @Nullable PirateApp pirateApp) {
                    Intrinsics.checkParameterIsNotNull(piracyCheckerError, "<anonymous parameter 0>");
                }
            };
        }
        Intrinsics.checkParameterIsNotNull(doNotAllow, "$this$doNotAllow");
        Intrinsics.checkParameterIsNotNull(doNotAllow2, "doNotAllow");
        doNotAllow.doNotAllowCallback(new DoNotAllowCallback() { // from class: com.github.javiersantos.piracychecker.ExtensionsKt$doNotAllow$$inlined$apply$lambda$2
            @Override // com.github.javiersantos.piracychecker.callbacks.DoNotAllowCallback
            public void doNotAllow(@NotNull PiracyCheckerError error, @Nullable PirateApp pirateApp) {
                Intrinsics.checkParameterIsNotNull(error, "error");
                Function2.this.mo1invoke(error, pirateApp);
            }

            @Override // com.github.javiersantos.piracychecker.callbacks.DoNotAllowCallback
            @Deprecated(message = "dontAllow has been deprecated in favor of doNotAllow", replaceWith = @ReplaceWith(expression = "doNotAllow", imports = {}))
            public void dontAllow(@NotNull PiracyCheckerError error, @Nullable PirateApp pirateApp) {
                Intrinsics.checkParameterIsNotNull(error, "error");
                DoNotAllowCallback.DefaultImpls.dontAllow(this, error, pirateApp);
            }
        });
        return doNotAllow;
    }

    @NotNull
    public static final PiracyChecker onError(@NotNull PiracyChecker onError, @NotNull final Function1<? super PiracyCheckerError, Unit> onError2) {
        Intrinsics.checkParameterIsNotNull(onError, "$this$onError");
        Intrinsics.checkParameterIsNotNull(onError2, "onError");
        onError.onErrorCallback(new OnErrorCallback() { // from class: com.github.javiersantos.piracychecker.ExtensionsKt$onError$$inlined$apply$lambda$1
            @Override // com.github.javiersantos.piracychecker.callbacks.OnErrorCallback
            public void onError(@NotNull PiracyCheckerError error) {
                Intrinsics.checkParameterIsNotNull(error, "error");
                OnErrorCallback.DefaultImpls.onError(this, error);
                Function1.this.invoke(error);
            }
        });
        return onError;
    }

    public static /* synthetic */ PiracyChecker onError$default(PiracyChecker onError, final Function1 onError2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            onError2 = new Function1<PiracyCheckerError, Unit>() { // from class: com.github.javiersantos.piracychecker.ExtensionsKt$onError$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PiracyCheckerError piracyCheckerError) {
                    invoke2(piracyCheckerError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PiracyCheckerError it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
        }
        Intrinsics.checkParameterIsNotNull(onError, "$this$onError");
        Intrinsics.checkParameterIsNotNull(onError2, "onError");
        onError.onErrorCallback(new OnErrorCallback() { // from class: com.github.javiersantos.piracychecker.ExtensionsKt$onError$$inlined$apply$lambda$2
            @Override // com.github.javiersantos.piracychecker.callbacks.OnErrorCallback
            public void onError(@NotNull PiracyCheckerError error) {
                Intrinsics.checkParameterIsNotNull(error, "error");
                OnErrorCallback.DefaultImpls.onError(this, error);
                Function1.this.invoke(error);
            }
        });
        return onError;
    }

    @NotNull
    public static final PiracyChecker piracyChecker(@NotNull Context piracyChecker, @NotNull Function1<? super PiracyChecker, Unit> builder) {
        Intrinsics.checkParameterIsNotNull(piracyChecker, "$this$piracyChecker");
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        PiracyChecker piracyChecker2 = new PiracyChecker(piracyChecker);
        builder.invoke(piracyChecker2);
        return piracyChecker2;
    }

    @NotNull
    public static final PiracyChecker piracyChecker(@NotNull Fragment piracyChecker, @NotNull Function1<? super PiracyChecker, Unit> builder) {
        PiracyChecker piracyChecker2;
        Intrinsics.checkParameterIsNotNull(piracyChecker, "$this$piracyChecker");
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        FragmentActivity activity = piracyChecker.getActivity();
        if (activity == null || (piracyChecker2 = piracyChecker(activity, builder)) == null) {
            Context requireContext = piracyChecker.requireContext();
            Intrinsics.checkExpressionValueIsNotNull(requireContext, "requireContext()");
            return piracyChecker(requireContext, builder);
        }
        return piracyChecker2;
    }
}
