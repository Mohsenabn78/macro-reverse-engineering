package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f1519a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1520b;

    /* renamed from: c  reason: collision with root package name */
    private final List<BaseKeyframeAnimation.AnimationListener> f1521c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final ShapeTrimPath.Type f1522d;

    /* renamed from: e  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1523e;

    /* renamed from: f  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1524f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1525g;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.f1519a = shapeTrimPath.getName();
        this.f1520b = shapeTrimPath.isHidden();
        this.f1522d = shapeTrimPath.getType();
        BaseKeyframeAnimation<Float, Float> createAnimation = shapeTrimPath.getStart().createAnimation();
        this.f1523e = createAnimation;
        BaseKeyframeAnimation<Float, Float> createAnimation2 = shapeTrimPath.getEnd().createAnimation();
        this.f1524f = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = shapeTrimPath.getOffset().createAnimation();
        this.f1525g = createAnimation3;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.f1521c.add(animationListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type b() {
        return this.f1522d;
    }

    public BaseKeyframeAnimation<?, Float> getEnd() {
        return this.f1524f;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1519a;
    }

    public BaseKeyframeAnimation<?, Float> getOffset() {
        return this.f1525g;
    }

    public BaseKeyframeAnimation<?, Float> getStart() {
        return this.f1523e;
    }

    public boolean isHidden() {
        return this.f1520b;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        for (int i4 = 0; i4 < this.f1521c.size(); i4++) {
            this.f1521c.get(i4).onValueChanged();
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }
}
