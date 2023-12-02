package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public final class OffsetEdgeTreatment extends EdgeTreatment {

    /* renamed from: a  reason: collision with root package name */
    private final EdgeTreatment f24242a;

    /* renamed from: b  reason: collision with root package name */
    private final float f24243b;

    public OffsetEdgeTreatment(@NonNull EdgeTreatment edgeTreatment, float f4) {
        this.f24242a = edgeTreatment;
        this.f24243b = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean a() {
        return this.f24242a.a();
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        this.f24242a.getEdgePath(f4, f5 - this.f24243b, f6, shapePath);
    }
}
