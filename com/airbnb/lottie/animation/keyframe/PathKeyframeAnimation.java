package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes2.dex */
public class PathKeyframeAnimation extends a<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f1546i;

    /* renamed from: j  reason: collision with root package name */
    private final float[] f1547j;

    /* renamed from: k  reason: collision with root package name */
    private final PathMeasure f1548k;

    /* renamed from: l  reason: collision with root package name */
    private PathKeyframe f1549l;

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
        this.f1546i = new PointF();
        this.f1547j = new float[2];
        this.f1548k = new PathMeasure();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f4) {
        return getValue((Keyframe<PointF>) keyframe, f4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> keyframe, float f4) {
        PointF pointF;
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path a4 = pathKeyframe.a();
        if (a4 == null) {
            return keyframe.startValue;
        }
        LottieValueCallback<A> lottieValueCallback = this.f1530e;
        if (lottieValueCallback == 0 || (pointF = (PointF) lottieValueCallback.getValueInternal(pathKeyframe.startFrame, pathKeyframe.endFrame.floatValue(), pathKeyframe.startValue, pathKeyframe.endValue, d(), f4, getProgress())) == null) {
            if (this.f1549l != pathKeyframe) {
                this.f1548k.setPath(a4, false);
                this.f1549l = pathKeyframe;
            }
            PathMeasure pathMeasure = this.f1548k;
            pathMeasure.getPosTan(f4 * pathMeasure.getLength(), this.f1547j, null);
            PointF pointF2 = this.f1546i;
            float[] fArr = this.f1547j;
            pointF2.set(fArr[0], fArr[1]);
            return this.f1546i;
        }
        return pointF;
    }
}
