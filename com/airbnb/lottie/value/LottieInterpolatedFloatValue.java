package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes2.dex */
public class LottieInterpolatedFloatValue extends a<Float> {
    public LottieInterpolatedFloatValue(Float f4, Float f5) {
        super(f4, f5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.a
    /* renamed from: b */
    public Float a(Float f4, Float f5, float f6) {
        return Float.valueOf(MiscUtils.lerp(f4.floatValue(), f5.floatValue(), f6));
    }

    @Override // com.airbnb.lottie.value.a, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    public LottieInterpolatedFloatValue(Float f4, Float f5, Interpolator interpolator) {
        super(f4, f5, interpolator);
    }
}
