package com.arlosoft.macrodroid.extensions;

import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: DrawableExtensions.kt */
/* loaded from: classes3.dex */
public final class DrawableExtensionsKt {
    @NotNull
    public static final Drawable tint(@NotNull Drawable drawable, int i4) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        Drawable.ConstantState constantState = drawable.getConstantState();
        Intrinsics.checkNotNull(constantState);
        Drawable mutate = constantState.newDrawable().mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "this.constantState!!.newDrawable().mutate()");
        DrawableCompat.setTint(mutate, i4);
        drawable.invalidateSelf();
        return mutate;
    }
}
