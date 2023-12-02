package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes5.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

    private MaterialColors() {
    }

    @ColorInt
    private static int a(@ColorInt int i4, @IntRange(from = 0, to = 100) int i5) {
        Hct c4 = Hct.c(i4);
        c4.j(i5);
        return c4.k();
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
        return androidx.core.graphics.ColorUtils.setAlphaComponent(i4, (Color.alpha(i4) * i5) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i4) {
        return MaterialAttributes.resolveOrThrow(view, i4);
    }

    @NonNull
    public static ColorRoles getColorRoles(@NonNull Context context, @ColorInt int i4) {
        return getColorRoles(i4, MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true));
    }

    @ColorInt
    public static int harmonize(@ColorInt int i4, @ColorInt int i5) {
        return Blend.a(i4, i5);
    }

    @ColorInt
    public static int harmonizeWithPrimary(@NonNull Context context, @ColorInt int i4) {
        return harmonize(i4, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(@ColorInt int i4) {
        if (i4 != 0 && androidx.core.graphics.ColorUtils.calculateLuminance(i4) > 0.5d) {
            return true;
        }
        return false;
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i4, @AttrRes int i5) {
        return layer(view, i4, i5, 1.0f);
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i4, String str) {
        return MaterialAttributes.resolveOrThrow(context, i4, str);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i4, @AttrRes int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return layer(getColor(view, i4), getColor(view, i5), f4);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i4, @ColorInt int i5) {
        return getColor(view.getContext(), i4, i5);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i4, @ColorInt int i5) {
        TypedValue resolve = MaterialAttributes.resolve(context, i4);
        return resolve != null ? resolve.data : i5;
    }

    @NonNull
    public static ColorRoles getColorRoles(@ColorInt int i4, boolean z3) {
        if (z3) {
            return new ColorRoles(a(i4, 40), a(i4, 100), a(i4, 90), a(i4, 10));
        }
        return new ColorRoles(a(i4, 70), a(i4, 10), a(i4, 20), a(i4, 80));
    }

    @ColorInt
    public static int layer(@ColorInt int i4, @ColorInt int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return layer(i4, androidx.core.graphics.ColorUtils.setAlphaComponent(i5, Math.round(Color.alpha(i5) * f4)));
    }

    @ColorInt
    public static int layer(@ColorInt int i4, @ColorInt int i5) {
        return androidx.core.graphics.ColorUtils.compositeColors(i5, i4);
    }
}
