package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes2.dex */
public class LottieInterpolatedPointValue extends a<PointF> {

    /* renamed from: g  reason: collision with root package name */
    private final PointF f1887g;

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.f1887g = new PointF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.a
    /* renamed from: b */
    public PointF a(PointF pointF, PointF pointF2, float f4) {
        this.f1887g.set(MiscUtils.lerp(pointF.x, pointF2.x, f4), MiscUtils.lerp(pointF.y, pointF2.y, f4));
        return this.f1887g;
    }

    @Override // com.airbnb.lottie.value.a, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.f1887g = new PointF();
    }
}
