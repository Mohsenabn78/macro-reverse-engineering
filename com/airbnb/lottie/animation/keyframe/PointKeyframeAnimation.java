package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes2.dex */
public class PointKeyframeAnimation extends a<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f1550i;

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.f1550i = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f4) {
        return getValue((Keyframe<PointF>) keyframe, f4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: h */
    public PointF f(Keyframe<PointF> keyframe, float f4, float f5, float f6) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = keyframe.startValue;
        if (pointF3 != null && (pointF = keyframe.endValue) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            LottieValueCallback<A> lottieValueCallback = this.f1530e;
            if (lottieValueCallback != 0 && (pointF2 = (PointF) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF4, pointF5, f4, d(), getProgress())) != null) {
                return pointF2;
            }
            PointF pointF6 = this.f1550i;
            float f7 = pointF4.x;
            float f8 = f7 + (f5 * (pointF5.x - f7));
            float f9 = pointF4.y;
            pointF6.set(f8, f9 + (f6 * (pointF5.y - f9)));
            return this.f1550i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> keyframe, float f4) {
        return f(keyframe, f4, f4, f4);
    }
}
