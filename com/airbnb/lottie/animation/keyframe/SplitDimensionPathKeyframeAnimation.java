package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* loaded from: classes2.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f1554i;

    /* renamed from: j  reason: collision with root package name */
    private final PointF f1555j;

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f1556k;

    /* renamed from: l  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f1557l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    protected LottieValueCallback<Float> f1558m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    protected LottieValueCallback<Float> f1559n;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.f1554i = new PointF();
        this.f1555j = new PointF();
        this.f1556k = baseKeyframeAnimation;
        this.f1557l = baseKeyframeAnimation2;
        setProgress(getProgress());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float f4) {
        this.f1556k.setProgress(f4);
        this.f1557l.setProgress(f4);
        this.f1554i.set(this.f1556k.getValue().floatValue(), this.f1557l.getValue().floatValue());
        for (int i4 = 0; i4 < this.f1526a.size(); i4++) {
            this.f1526a.get(i4).onValueChanged();
        }
    }

    public void setXValueCallback(@Nullable LottieValueCallback<Float> lottieValueCallback) {
        LottieValueCallback<Float> lottieValueCallback2 = this.f1558m;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.f1558m = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }

    public void setYValueCallback(@Nullable LottieValueCallback<Float> lottieValueCallback) {
        LottieValueCallback<Float> lottieValueCallback2 = this.f1559n;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.f1559n = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue() {
        return getValue((Keyframe<PointF>) null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> keyframe, float f4) {
        Float f5;
        Keyframe<Float> a4;
        Keyframe<Float> a5;
        Float f6 = null;
        if (this.f1558m == null || (a5 = this.f1556k.a()) == null) {
            f5 = null;
        } else {
            float c4 = this.f1556k.c();
            Float f7 = a5.endFrame;
            LottieValueCallback<Float> lottieValueCallback = this.f1558m;
            float f8 = a5.startFrame;
            f5 = lottieValueCallback.getValueInternal(f8, f7 == null ? f8 : f7.floatValue(), a5.startValue, a5.endValue, f4, f4, c4);
        }
        if (this.f1559n != null && (a4 = this.f1557l.a()) != null) {
            float c5 = this.f1557l.c();
            Float f9 = a4.endFrame;
            LottieValueCallback<Float> lottieValueCallback2 = this.f1559n;
            float f10 = a4.startFrame;
            f6 = lottieValueCallback2.getValueInternal(f10, f9 == null ? f10 : f9.floatValue(), a4.startValue, a4.endValue, f4, f4, c5);
        }
        if (f5 == null) {
            this.f1555j.set(this.f1554i.x, 0.0f);
        } else {
            this.f1555j.set(f5.floatValue(), 0.0f);
        }
        if (f6 == null) {
            PointF pointF = this.f1555j;
            pointF.set(pointF.x, this.f1554i.y);
        } else {
            PointF pointF2 = this.f1555j;
            pointF2.set(pointF2.x, f6.floatValue());
        }
        return this.f1555j;
    }
}
