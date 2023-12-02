package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f22892a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f22893b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f22894c = new Matrix();

    @Override // android.animation.TypeEvaluator
    @NonNull
    public Matrix evaluate(float f4, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.f22892a);
        matrix2.getValues(this.f22893b);
        for (int i4 = 0; i4 < 9; i4++) {
            float[] fArr = this.f22893b;
            float f5 = fArr[i4];
            float f6 = this.f22892a[i4];
            fArr[i4] = f6 + ((f5 - f6) * f4);
        }
        this.f22894c.setValues(this.f22893b);
        return this.f22894c;
    }
}
