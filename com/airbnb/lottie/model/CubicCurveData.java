package com.airbnb.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class CubicCurveData {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f1587a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f1588b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f1589c;

    public CubicCurveData() {
        this.f1587a = new PointF();
        this.f1588b = new PointF();
        this.f1589c = new PointF();
    }

    public PointF getControlPoint1() {
        return this.f1587a;
    }

    public PointF getControlPoint2() {
        return this.f1588b;
    }

    public PointF getVertex() {
        return this.f1589c;
    }

    public void setControlPoint1(float f4, float f5) {
        this.f1587a.set(f4, f5);
    }

    public void setControlPoint2(float f4, float f5) {
        this.f1588b.set(f4, f5);
    }

    public void setVertex(float f4, float f5) {
        this.f1589c.set(f4, f5);
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f1587a = pointF;
        this.f1588b = pointF2;
        this.f1589c = pointF3;
    }
}
