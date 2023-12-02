package com.arlosoft.macrodroid.utils;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToastHelper.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class ToastHelper {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f16086a;

    @Inject
    public ToastHelper(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f16086a = context;
    }

    @NotNull
    public final Context getContext() {
        return this.f16086a;
    }

    public final void showToast(@NotNull String message, boolean z3) {
        Intrinsics.checkNotNullParameter(message, "message");
        ToastCompat.makeText(this.f16086a, (CharSequence) message, z3 ? 1 : 0).show();
    }
}
