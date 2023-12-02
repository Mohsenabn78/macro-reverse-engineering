package com.google.android.material.ripple;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class RippleUtils {
    public static final boolean USE_FRAMEWORK_RIPPLE = true;

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f24140a = {16842919};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f24141b = {16843623, 16842908};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f24142c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f24143d = {16843623};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f24144e = {16842913, 16842919};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f24145f = {16842913, 16843623, 16842908};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f24146g = {16842913, 16842908};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f24147h = {16842913, 16843623};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f24148i = {16842913};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f24149j = {16842910, 16842919};
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    static final String f24150k = RippleUtils.class.getSimpleName();

    private RippleUtils() {
    }

    @ColorInt
    @TargetApi(21)
    private static int a(@ColorInt int i4) {
        return ColorUtils.setAlphaComponent(i4, Math.min(Color.alpha(i4) * 2, 255));
    }

    @ColorInt
    private static int b(@Nullable ColorStateList colorStateList, int[] iArr) {
        int i4;
        if (colorStateList != null) {
            i4 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i4 = 0;
        }
        if (USE_FRAMEWORK_RIPPLE) {
            return a(i4);
        }
        return i4;
    }

    @NonNull
    public static ColorStateList convertToRippleDrawableColor(@Nullable ColorStateList colorStateList) {
        if (USE_FRAMEWORK_RIPPLE) {
            return new ColorStateList(new int[][]{f24148i, StateSet.NOTHING}, new int[]{b(colorStateList, f24144e), b(colorStateList, f24140a)});
        }
        int[] iArr = f24144e;
        int[] iArr2 = f24145f;
        int[] iArr3 = f24146g;
        int[] iArr4 = f24147h;
        int[] iArr5 = f24140a;
        int[] iArr6 = f24141b;
        int[] iArr7 = f24142c;
        int[] iArr8 = f24143d;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f24148i, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{b(colorStateList, iArr), b(colorStateList, iArr2), b(colorStateList, iArr3), b(colorStateList, iArr4), 0, b(colorStateList, iArr5), b(colorStateList, iArr6), b(colorStateList, iArr7), b(colorStateList, iArr8), 0});
    }

    @NonNull
    public static ColorStateList sanitizeRippleDrawableColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 22 && i4 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f24149j, 0)) != 0) {
                Log.w(f24150k, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean shouldDrawRippleCompat(@NonNull int[] iArr) {
        boolean z3 = false;
        boolean z4 = false;
        for (int i4 : iArr) {
            if (i4 == 16842910) {
                z3 = true;
            } else if (i4 == 16842908 || i4 == 16842919 || i4 == 16843623) {
                z4 = true;
            }
        }
        if (!z3 || !z4) {
            return false;
        }
        return true;
    }
}
