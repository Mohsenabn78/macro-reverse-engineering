package com.airbnb.lottie.value;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes2.dex */
public class LottieRelativePointValueCallback extends LottieValueCallback<PointF> {

    /* renamed from: d  reason: collision with root package name */
    private final PointF f1888d;

    public LottieRelativePointValueCallback() {
        this.f1888d = new PointF();
    }

    public PointF getOffset(LottieFrameInfo<PointF> lottieFrameInfo) {
        T t3 = this.f1891c;
        if (t3 != 0) {
            return (PointF) t3;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public final PointF getValue(LottieFrameInfo<PointF> lottieFrameInfo) {
        this.f1888d.set(MiscUtils.lerp(lottieFrameInfo.getStartValue().x, lottieFrameInfo.getEndValue().x, lottieFrameInfo.getInterpolatedKeyframeProgress()), MiscUtils.lerp(lottieFrameInfo.getStartValue().y, lottieFrameInfo.getEndValue().y, lottieFrameInfo.getInterpolatedKeyframeProgress()));
        PointF offset = getOffset(lottieFrameInfo);
        this.f1888d.offset(offset.x, offset.y);
        return this.f1888d;
    }

    public LottieRelativePointValueCallback(@NonNull PointF pointF) {
        super(pointF);
        this.f1888d = new PointF();
    }
}
