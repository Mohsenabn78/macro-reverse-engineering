package com.arlosoft.macrodroid.toast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.compose.runtime.internal.StabilityInferred;
import es.dmoral.toasty.Toasty;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CustomToastHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CustomToastHelper {
    public static final int $stable = 0;
    @NotNull
    public static final CustomToastHelper INSTANCE = new CustomToastHelper();

    private CustomToastHelper() {
    }

    @JvmStatic
    public static final void displayCustomToast(@NotNull Context context, @NotNull String message, @ColorInt int i4, int i5, int i6, int i7, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        if (Build.VERSION.SDK_INT < 29) {
            Toasty.Config.getInstance().setTextColor(i4).apply();
            Toasty.custom(context, message, i5, i6, i7, z3, z4).show();
            return;
        }
        ToastCompat.makeText(context, (CharSequence) message, 1).show();
    }

    @JvmStatic
    public static final void displayCustomToast(@NotNull Context context, @NotNull String message, @ColorInt int i4, @Nullable Drawable drawable, int i5, int i6, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        if (Build.VERSION.SDK_INT < 29) {
            Toasty.Config.getInstance().setTextColor(i4).apply();
            Toasty.custom(context, message, drawable, i5, i6, z3, z4).show();
            return;
        }
        ToastCompat.makeText(context, (CharSequence) message, 1).show();
    }
}
