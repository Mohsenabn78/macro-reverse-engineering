package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes2.dex */
public class EllipseContent implements b, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: b  reason: collision with root package name */
    private final String f1419b;

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f1420c;

    /* renamed from: d  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f1421d;

    /* renamed from: e  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f1422e;

    /* renamed from: f  reason: collision with root package name */
    private final CircleShape f1423f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1425h;

    /* renamed from: a  reason: collision with root package name */
    private final Path f1418a = new Path();

    /* renamed from: g  reason: collision with root package name */
    private CompoundTrimPathContent f1424g = new CompoundTrimPathContent();

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, CircleShape circleShape) {
        this.f1419b = circleShape.getName();
        this.f1420c = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = circleShape.getSize().createAnimation();
        this.f1421d = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = circleShape.getPosition().createAnimation();
        this.f1422e = createAnimation2;
        this.f1423f = circleShape;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
    }

    private void a() {
        this.f1425h = false;
        this.f1420c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t3 == LottieProperty.ELLIPSE_SIZE) {
            this.f1421d.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.POSITION) {
            this.f1422e.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1419b;
    }

    @Override // com.airbnb.lottie.animation.content.b
    public Path getPath() {
        if (this.f1425h) {
            return this.f1418a;
        }
        this.f1418a.reset();
        if (this.f1423f.isHidden()) {
            this.f1425h = true;
            return this.f1418a;
        }
        PointF value = this.f1421d.getValue();
        float f4 = value.x / 2.0f;
        float f5 = value.y / 2.0f;
        float f6 = f4 * 0.55228f;
        float f7 = 0.55228f * f5;
        this.f1418a.reset();
        if (this.f1423f.isReversed()) {
            float f8 = -f5;
            this.f1418a.moveTo(0.0f, f8);
            float f9 = 0.0f - f6;
            float f10 = -f4;
            float f11 = 0.0f - f7;
            this.f1418a.cubicTo(f9, f8, f10, f11, f10, 0.0f);
            float f12 = f7 + 0.0f;
            this.f1418a.cubicTo(f10, f12, f9, f5, 0.0f, f5);
            float f13 = f6 + 0.0f;
            this.f1418a.cubicTo(f13, f5, f4, f12, f4, 0.0f);
            this.f1418a.cubicTo(f4, f11, f13, f8, 0.0f, f8);
        } else {
            float f14 = -f5;
            this.f1418a.moveTo(0.0f, f14);
            float f15 = f6 + 0.0f;
            float f16 = 0.0f - f7;
            this.f1418a.cubicTo(f15, f14, f4, f16, f4, 0.0f);
            float f17 = f7 + 0.0f;
            this.f1418a.cubicTo(f4, f17, f15, f5, 0.0f, f5);
            float f18 = 0.0f - f6;
            float f19 = -f4;
            this.f1418a.cubicTo(f18, f5, f19, f17, f19, 0.0f);
            this.f1418a.cubicTo(f19, f16, f18, f14, 0.0f, f14);
        }
        PointF value2 = this.f1422e.getValue();
        this.f1418a.offset(value2.x, value2.y);
        this.f1418a.close();
        this.f1424g.apply(this.f1418a);
        this.f1425h = true;
        return this.f1418a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        a();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i4, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i4, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            Content content = list.get(i4);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.b() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f1424g.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
        }
    }
}
