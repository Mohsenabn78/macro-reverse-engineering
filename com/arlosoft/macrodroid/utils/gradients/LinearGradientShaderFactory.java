package com.arlosoft.macrodroid.utils.gradients;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: LinearGradientShaderFactory.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LinearGradientShaderFactory extends ShapeDrawable.ShaderFactory {
    public static final int $stable = 8;

    /* renamed from: a  reason: collision with root package name */
    private final double f16112a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final int[] f16113b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final float[] f16114c;

    public LinearGradientShaderFactory(double d4, @NotNull int[] colors, @NotNull float[] positions) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(positions, "positions");
        this.f16112a = d4;
        this.f16113b = colors;
        this.f16114c = positions;
    }

    public final double getAngle() {
        return this.f16112a;
    }

    @NotNull
    public final int[] getColors() {
        return this.f16113b;
    }

    @NotNull
    public final float[] getPositions() {
        return this.f16114c;
    }

    @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
    @NotNull
    public Shader resize(int i4, int i5) {
        float f4;
        float f5;
        float f6;
        float f7;
        double radians = Math.toRadians(this.f16112a);
        double sqrt = Math.sqrt((i4 * i4) + (i5 * i5));
        float cos = (float) (Math.cos(radians) * sqrt);
        float sin = (float) (Math.sin(radians) * sqrt);
        if (cos < 0.0f) {
            float f8 = i4;
            f5 = f8;
            f4 = cos + f8;
        } else {
            f4 = cos;
            f5 = 0.0f;
        }
        if (sin < 0.0f) {
            float f9 = i5;
            f6 = sin + f9;
            f7 = f9;
        } else {
            f6 = sin;
            f7 = 0.0f;
        }
        return new LinearGradient(f5, f7, f4, f6, this.f16113b, this.f16114c, Shader.TileMode.REPEAT);
    }
}
