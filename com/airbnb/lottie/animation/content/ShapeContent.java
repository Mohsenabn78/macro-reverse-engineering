package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* loaded from: classes2.dex */
public class ShapeContent implements b, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: b  reason: collision with root package name */
    private final String f1508b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1509c;

    /* renamed from: d  reason: collision with root package name */
    private final LottieDrawable f1510d;

    /* renamed from: e  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Path> f1511e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1512f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f1507a = new Path();

    /* renamed from: g  reason: collision with root package name */
    private CompoundTrimPathContent f1513g = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapePath shapePath) {
        this.f1508b = shapePath.getName();
        this.f1509c = shapePath.isHidden();
        this.f1510d = lottieDrawable;
        BaseKeyframeAnimation<ShapeData, Path> createAnimation = shapePath.getShapePath().createAnimation();
        this.f1511e = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
    }

    private void a() {
        this.f1512f = false;
        this.f1510d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1508b;
    }

    @Override // com.airbnb.lottie.animation.content.b
    public Path getPath() {
        if (this.f1512f) {
            return this.f1507a;
        }
        this.f1507a.reset();
        if (this.f1509c) {
            this.f1512f = true;
            return this.f1507a;
        }
        this.f1507a.set(this.f1511e.getValue());
        this.f1507a.setFillType(Path.FillType.EVEN_ODD);
        this.f1513g.apply(this.f1507a);
        this.f1512f = true;
        return this.f1507a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        a();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            Content content = list.get(i4);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.b() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f1513g.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
        }
    }
}
