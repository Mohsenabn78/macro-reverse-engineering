package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MaskKeyframeAnimation {

    /* renamed from: a  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<ShapeData, Path>> f1541a;

    /* renamed from: b  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<Integer, Integer>> f1542b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Mask> f1543c;

    public MaskKeyframeAnimation(List<Mask> list) {
        this.f1543c = list;
        this.f1541a = new ArrayList(list.size());
        this.f1542b = new ArrayList(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f1541a.add(list.get(i4).getMaskPath().createAnimation());
            this.f1542b.add(list.get(i4).getOpacity().createAnimation());
        }
    }

    public List<BaseKeyframeAnimation<ShapeData, Path>> getMaskAnimations() {
        return this.f1541a;
    }

    public List<Mask> getMasks() {
        return this.f1543c;
    }

    public List<BaseKeyframeAnimation<Integer, Integer>> getOpacityAnimations() {
        return this.f1542b;
    }
}
