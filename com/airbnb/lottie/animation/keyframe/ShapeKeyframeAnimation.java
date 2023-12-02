package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes2.dex */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {

    /* renamed from: i  reason: collision with root package name */
    private final ShapeData f1552i;

    /* renamed from: j  reason: collision with root package name */
    private final Path f1553j;

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
        this.f1552i = new ShapeData();
        this.f1553j = new Path();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Path getValue(Keyframe<ShapeData> keyframe, float f4) {
        this.f1552i.interpolateBetween(keyframe.startValue, keyframe.endValue, f4);
        MiscUtils.getPathFromData(this.f1552i, this.f1553j);
        return this.f1553j;
    }
}
