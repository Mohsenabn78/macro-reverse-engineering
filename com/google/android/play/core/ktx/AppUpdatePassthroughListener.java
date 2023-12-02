package com.google.android.play.core.ktx;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.play:app-update-ktx@@2.0.1 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\t\u001a\u00020\u0001\u0012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0002\b\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0002\b\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdatePassthroughListener;", "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "Lcom/google/android/play/core/install/InstallState;", RemoteConfigConstants.ResponseFieldKey.STATE, "", "a", "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "getListener", "()Lcom/google/android/play/core/install/InstallStateUpdatedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "b", "Lkotlin/jvm/functions/Function1;", "getDisposeAction", "()Lkotlin/jvm/functions/Function1;", "disposeAction", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/google/android/play/core/install/InstallStateUpdatedListener;Lkotlin/jvm/functions/Function1;)V", "java.com.google.android.apps.play.store.sdk.playcore.ktx_playcore_app_update_ktx"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
final class AppUpdatePassthroughListener implements InstallStateUpdatedListener {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final InstallStateUpdatedListener f25325a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function1<AppUpdatePassthroughListener, Unit> f25326b;

    /* JADX WARN: Multi-variable type inference failed */
    public AppUpdatePassthroughListener(@NotNull InstallStateUpdatedListener listener, @NotNull Function1<? super AppUpdatePassthroughListener, Unit> disposeAction) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(disposeAction, "disposeAction");
        this.f25325a = listener;
        this.f25326b = disposeAction;
    }

    @Override // com.google.android.play.core.listener.StateUpdatedListener
    /* renamed from: a */
    public final void onStateUpdate(@NotNull InstallState state) {
        boolean z3;
        Intrinsics.checkNotNullParameter(state, "state");
        this.f25325a.onStateUpdate(state);
        int installStatus = state.installStatus();
        if (installStatus != 0 && installStatus != 11 && installStatus != 5 && installStatus != 6) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            this.f25326b.invoke(this);
        }
    }
}
