package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {

    /* renamed from: a  reason: collision with root package name */
    private final float f24309a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f24310b;

    public TriangleEdgeTreatment(float f4, boolean z3) {
        this.f24309a = f4;
        this.f24310b = z3;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        float f7;
        shapePath.lineTo(f5 - (this.f24309a * f6), 0.0f);
        if (this.f24310b) {
            f7 = this.f24309a;
        } else {
            f7 = -this.f24309a;
        }
        shapePath.lineTo(f5, f7 * f6);
        shapePath.lineTo(f5 + (this.f24309a * f6), 0.0f);
        shapePath.lineTo(f4, 0.0f);
    }
}
