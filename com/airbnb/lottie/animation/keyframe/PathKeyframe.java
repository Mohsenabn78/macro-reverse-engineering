package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

/* loaded from: classes2.dex */
public class PathKeyframe extends Keyframe<PointF> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Path f1544h;

    /* renamed from: i  reason: collision with root package name */
    private final Keyframe<PointF> f1545i;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.xInterpolator, keyframe.yInterpolator, keyframe.startFrame, keyframe.endFrame);
        this.f1545i = keyframe;
        createPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path a() {
        return this.f1544h;
    }

    public void createPath() {
        boolean z3;
        T t3;
        T t4;
        T t5 = this.endValue;
        if (t5 != 0 && (t4 = this.startValue) != 0 && ((PointF) t4).equals(((PointF) t5).x, ((PointF) t5).y)) {
            z3 = true;
        } else {
            z3 = false;
        }
        T t6 = this.startValue;
        if (t6 != 0 && (t3 = this.endValue) != 0 && !z3) {
            Keyframe<PointF> keyframe = this.f1545i;
            this.f1544h = Utils.createPath((PointF) t6, (PointF) t3, keyframe.pathCp1, keyframe.pathCp2);
        }
    }
}
