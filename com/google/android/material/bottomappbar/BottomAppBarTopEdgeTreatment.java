package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* loaded from: classes5.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private float f23121a;

    /* renamed from: b  reason: collision with root package name */
    private float f23122b;

    /* renamed from: c  reason: collision with root package name */
    private float f23123c;

    /* renamed from: d  reason: collision with root package name */
    private float f23124d;

    /* renamed from: e  reason: collision with root package name */
    private float f23125e;

    /* renamed from: f  reason: collision with root package name */
    private float f23126f = -1.0f;

    public BottomAppBarTopEdgeTreatment(float f4, float f5, float f6) {
        this.f23122b = f4;
        this.f23121a = f5;
        e(f6);
        this.f23125e = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f23124d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f23122b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f23121a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(@FloatRange(from = 0.0d) float f4) {
        if (f4 >= 0.0f) {
            this.f23124d = f4;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(float f4) {
        this.f23122b = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f4) {
        this.f23121a = f4;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        boolean z3;
        float f7;
        float f8;
        float f9 = this.f23123c;
        if (f9 == 0.0f) {
            shapePath.lineTo(f4, 0.0f);
            return;
        }
        float f10 = ((this.f23122b * 2.0f) + f9) / 2.0f;
        float f11 = f6 * this.f23121a;
        float f12 = f5 + this.f23125e;
        float f13 = (this.f23124d * f6) + ((1.0f - f6) * f10);
        if (f13 / f10 >= 1.0f) {
            shapePath.lineTo(f4, 0.0f);
            return;
        }
        float f14 = this.f23126f;
        float f15 = f14 * f6;
        if (f14 != -1.0f && Math.abs((f14 * 2.0f) - f9) >= 0.1f) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            f8 = 1.75f;
            f7 = 0.0f;
        } else {
            f7 = f13;
            f8 = 0.0f;
        }
        float f16 = f10 + f11;
        float f17 = f7 + f11;
        float sqrt = (float) Math.sqrt((f16 * f16) - (f17 * f17));
        float f18 = f12 - sqrt;
        float f19 = f12 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f17));
        float f20 = (90.0f - degrees) + f8;
        shapePath.lineTo(f18, 0.0f);
        float f21 = f11 * 2.0f;
        shapePath.addArc(f18 - f11, 0.0f, f18 + f11, f21, 270.0f, degrees);
        if (z3) {
            shapePath.addArc(f12 - f10, (-f10) - f7, f12 + f10, f10 - f7, 180.0f - f20, (f20 * 2.0f) - 180.0f);
        } else {
            float f22 = this.f23122b;
            float f23 = f15 * 2.0f;
            float f24 = f12 - f10;
            shapePath.addArc(f24, -(f15 + f22), f24 + f22 + f23, f22 + f15, 180.0f - f20, ((f20 * 2.0f) - 180.0f) / 2.0f);
            float f25 = f12 + f10;
            float f26 = this.f23122b;
            shapePath.lineTo(f25 - ((f26 / 2.0f) + f15), f26 + f15);
            float f27 = this.f23122b;
            shapePath.addArc(f25 - (f23 + f27), -(f15 + f27), f25, f27 + f15, 90.0f, f20 - 90.0f);
        }
        shapePath.addArc(f19 - f11, 0.0f, f19 + f11, f21, 270.0f - degrees, degrees);
        shapePath.lineTo(f4, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.f23126f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.f23123c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.f23125e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f4) {
        this.f23125e = f4;
    }

    public void setFabCornerSize(float f4) {
        this.f23126f = f4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f4) {
        this.f23123c = f4;
    }
}
