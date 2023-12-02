package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<Keyframe<PointF>> f1609a;

    public AnimatablePathValue() {
        this.f1609a = Collections.singletonList(new Keyframe(new PointF(0.0f, 0.0f)));
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        if (this.f1609a.get(0).isStatic()) {
            return new PointKeyframeAnimation(this.f1609a);
        }
        return new PathKeyframeAnimation(this.f1609a);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<Keyframe<PointF>> getKeyframes() {
        return this.f1609a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        if (this.f1609a.size() != 1 || !this.f1609a.get(0).isStatic()) {
            return false;
        }
        return true;
    }

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.f1609a = list;
    }
}
