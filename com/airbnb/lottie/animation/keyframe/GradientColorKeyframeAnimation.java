package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes2.dex */
public class GradientColorKeyframeAnimation extends a<GradientColor> {

    /* renamed from: i  reason: collision with root package name */
    private final GradientColor f1540i;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor gradientColor = list.get(0).startValue;
        int size = gradientColor != null ? gradientColor.getSize() : 0;
        this.f1540i = new GradientColor(new float[size], new int[size]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: h */
    public GradientColor getValue(Keyframe<GradientColor> keyframe, float f4) {
        this.f1540i.lerp(keyframe.startValue, keyframe.endValue, f4);
        return this.f1540i;
    }
}
