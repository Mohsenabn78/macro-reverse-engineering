package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {

    /* renamed from: a  reason: collision with root package name */
    private final float f24191a;

    public MarkerEdgeTreatment(float f4) {
        this.f24191a = f4 - 0.001f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean a() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        float sqrt = (float) ((this.f24191a * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.f24191a, 2.0d) - Math.pow(sqrt, 2.0d));
        shapePath.reset(f5 - sqrt, ((float) (-((this.f24191a * Math.sqrt(2.0d)) - this.f24191a))) + sqrt2);
        shapePath.lineTo(f5, (float) (-((this.f24191a * Math.sqrt(2.0d)) - this.f24191a)));
        shapePath.lineTo(f5 + sqrt, ((float) (-((this.f24191a * Math.sqrt(2.0d)) - this.f24191a))) + sqrt2);
    }
}
