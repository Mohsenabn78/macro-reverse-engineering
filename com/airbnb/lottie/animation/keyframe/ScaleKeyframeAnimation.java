package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

/* loaded from: classes2.dex */
public class ScaleKeyframeAnimation extends a<ScaleXY> {

    /* renamed from: i  reason: collision with root package name */
    private final ScaleXY f1551i;

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
        this.f1551i = new ScaleXY();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f4) {
        return getValue((Keyframe<ScaleXY>) keyframe, f4);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public ScaleXY getValue(Keyframe<ScaleXY> keyframe, float f4) {
        ScaleXY scaleXY;
        ScaleXY scaleXY2;
        ScaleXY scaleXY3 = keyframe.startValue;
        if (scaleXY3 != null && (scaleXY = keyframe.endValue) != null) {
            ScaleXY scaleXY4 = scaleXY3;
            ScaleXY scaleXY5 = scaleXY;
            LottieValueCallback<A> lottieValueCallback = this.f1530e;
            if (lottieValueCallback == 0 || (scaleXY2 = (ScaleXY) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), scaleXY4, scaleXY5, f4, d(), getProgress())) == null) {
                this.f1551i.set(MiscUtils.lerp(scaleXY4.getScaleX(), scaleXY5.getScaleX(), f4), MiscUtils.lerp(scaleXY4.getScaleY(), scaleXY5.getScaleY(), f4));
                return this.f1551i;
            }
            return scaleXY2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
