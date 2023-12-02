package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes2.dex */
public class ColorKeyframeAnimation extends a<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    public int getIntValue(Keyframe<Integer> keyframe, float f4) {
        Integer num;
        Integer num2 = keyframe.startValue;
        if (num2 != null && keyframe.endValue != null) {
            int intValue = num2.intValue();
            int intValue2 = keyframe.endValue.intValue();
            LottieValueCallback<A> lottieValueCallback = this.f1530e;
            if (lottieValueCallback != 0 && (num = (Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f4, d(), getProgress())) != null) {
                return num.intValue();
            }
            return GammaEvaluator.evaluate(MiscUtils.clamp(f4, 0.0f, 1.0f), intValue, intValue2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: h */
    public Integer getValue(Keyframe<Integer> keyframe, float f4) {
        return Integer.valueOf(getIntValue(keyframe, f4));
    }

    public int getIntValue() {
        return getIntValue(a(), c());
    }
}
