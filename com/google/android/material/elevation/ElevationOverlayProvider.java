package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes5.dex */
public class ElevationOverlayProvider {

    /* renamed from: f  reason: collision with root package name */
    private static final int f23602f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23603a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23604b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23605c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23606d;

    /* renamed from: e  reason: collision with root package name */
    private final float f23607e;

    public ElevationOverlayProvider(@NonNull Context context) {
        this(MaterialAttributes.resolveBoolean(context, R.attr.elevationOverlayEnabled, false), MaterialColors.getColor(context, R.attr.elevationOverlayColor, 0), MaterialColors.getColor(context, R.attr.elevationOverlayAccentColor, 0), MaterialColors.getColor(context, R.attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean a(@ColorInt int i4) {
        if (ColorUtils.setAlphaComponent(i4, 255) == this.f23606d) {
            return true;
        }
        return false;
    }

    public int calculateOverlayAlpha(float f4) {
        return Math.round(calculateOverlayAlphaFraction(f4) * 255.0f);
    }

    public float calculateOverlayAlphaFraction(float f4) {
        float f5 = this.f23607e;
        if (f5 <= 0.0f || f4 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f4 / f5)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int i4, float f4, @NonNull View view) {
        return compositeOverlay(i4, f4 + getParentAbsoluteElevation(view));
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int i4, float f4, @NonNull View view) {
        return compositeOverlayIfNeeded(i4, f4 + getParentAbsoluteElevation(view));
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f4, @NonNull View view) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(f4 + getParentAbsoluteElevation(view));
    }

    public float getParentAbsoluteElevation(@NonNull View view) {
        return ViewUtils.getParentAbsoluteElevation(view);
    }

    @ColorInt
    public int getThemeElevationOverlayColor() {
        return this.f23604b;
    }

    @ColorInt
    public int getThemeSurfaceColor() {
        return this.f23606d;
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.f23603a;
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int i4, float f4) {
        int i5;
        float calculateOverlayAlphaFraction = calculateOverlayAlphaFraction(f4);
        int alpha = Color.alpha(i4);
        int layer = MaterialColors.layer(ColorUtils.setAlphaComponent(i4, 255), this.f23604b, calculateOverlayAlphaFraction);
        if (calculateOverlayAlphaFraction > 0.0f && (i5 = this.f23605c) != 0) {
            layer = MaterialColors.layer(layer, ColorUtils.setAlphaComponent(i5, f23602f));
        }
        return ColorUtils.setAlphaComponent(layer, alpha);
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int i4, float f4) {
        return (this.f23603a && a(i4)) ? compositeOverlay(i4, f4) : i4;
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f4) {
        return compositeOverlayIfNeeded(this.f23606d, f4);
    }

    public ElevationOverlayProvider(boolean z3, @ColorInt int i4, @ColorInt int i5, @ColorInt int i6, float f4) {
        this.f23603a = z3;
        this.f23604b = i4;
        this.f23605c = i5;
        this.f23606d = i6;
        this.f23607e = f4;
    }
}
