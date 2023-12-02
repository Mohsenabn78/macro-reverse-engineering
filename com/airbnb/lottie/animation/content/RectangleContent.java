package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes2.dex */
public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, b {

    /* renamed from: c  reason: collision with root package name */
    private final String f1489c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1490d;

    /* renamed from: e  reason: collision with root package name */
    private final LottieDrawable f1491e;

    /* renamed from: f  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f1492f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f1493g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1494h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1496j;

    /* renamed from: a  reason: collision with root package name */
    private final Path f1487a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f1488b = new RectF();

    /* renamed from: i  reason: collision with root package name */
    private CompoundTrimPathContent f1495i = new CompoundTrimPathContent();

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.f1489c = rectangleShape.getName();
        this.f1490d = rectangleShape.isHidden();
        this.f1491e = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = rectangleShape.getPosition().createAnimation();
        this.f1492f = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = rectangleShape.getSize().createAnimation();
        this.f1493g = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = rectangleShape.getCornerRadius().createAnimation();
        this.f1494h = createAnimation3;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
    }

    private void a() {
        this.f1496j = false;
        this.f1491e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t3 == LottieProperty.RECTANGLE_SIZE) {
            this.f1493g.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.POSITION) {
            this.f1492f.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.CORNER_RADIUS) {
            this.f1494h.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1489c;
    }

    @Override // com.airbnb.lottie.animation.content.b
    public Path getPath() {
        float floatValue;
        if (this.f1496j) {
            return this.f1487a;
        }
        this.f1487a.reset();
        if (this.f1490d) {
            this.f1496j = true;
            return this.f1487a;
        }
        PointF value = this.f1493g.getValue();
        float f4 = value.x / 2.0f;
        float f5 = value.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f1494h;
        if (baseKeyframeAnimation == null) {
            floatValue = 0.0f;
        } else {
            floatValue = ((FloatKeyframeAnimation) baseKeyframeAnimation).getFloatValue();
        }
        float min = Math.min(f4, f5);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF value2 = this.f1492f.getValue();
        this.f1487a.moveTo(value2.x + f4, (value2.y - f5) + floatValue);
        this.f1487a.lineTo(value2.x + f4, (value2.y + f5) - floatValue);
        int i4 = (floatValue > 0.0f ? 1 : (floatValue == 0.0f ? 0 : -1));
        if (i4 > 0) {
            RectF rectF = this.f1488b;
            float f6 = value2.x;
            float f7 = floatValue * 2.0f;
            float f8 = value2.y;
            rectF.set((f6 + f4) - f7, (f8 + f5) - f7, f6 + f4, f8 + f5);
            this.f1487a.arcTo(this.f1488b, 0.0f, 90.0f, false);
        }
        this.f1487a.lineTo((value2.x - f4) + floatValue, value2.y + f5);
        if (i4 > 0) {
            RectF rectF2 = this.f1488b;
            float f9 = value2.x;
            float f10 = value2.y;
            float f11 = floatValue * 2.0f;
            rectF2.set(f9 - f4, (f10 + f5) - f11, (f9 - f4) + f11, f10 + f5);
            this.f1487a.arcTo(this.f1488b, 90.0f, 90.0f, false);
        }
        this.f1487a.lineTo(value2.x - f4, (value2.y - f5) + floatValue);
        if (i4 > 0) {
            RectF rectF3 = this.f1488b;
            float f12 = value2.x;
            float f13 = value2.y;
            float f14 = floatValue * 2.0f;
            rectF3.set(f12 - f4, f13 - f5, (f12 - f4) + f14, (f13 - f5) + f14);
            this.f1487a.arcTo(this.f1488b, 180.0f, 90.0f, false);
        }
        this.f1487a.lineTo((value2.x + f4) - floatValue, value2.y - f5);
        if (i4 > 0) {
            RectF rectF4 = this.f1488b;
            float f15 = value2.x;
            float f16 = floatValue * 2.0f;
            float f17 = value2.y;
            rectF4.set((f15 + f4) - f16, f17 - f5, f15 + f4, (f17 - f5) + f16);
            this.f1487a.arcTo(this.f1488b, 270.0f, 90.0f, false);
        }
        this.f1487a.close();
        this.f1495i.apply(this.f1487a);
        this.f1496j = true;
        return this.f1487a;
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
                    this.f1495i.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
        }
    }
}
