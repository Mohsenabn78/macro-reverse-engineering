package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes2.dex */
public class StrokeContent extends BaseStrokeContent {

    /* renamed from: o  reason: collision with root package name */
    private final BaseLayer f1514o;

    /* renamed from: p  reason: collision with root package name */
    private final String f1515p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f1516q;

    /* renamed from: r  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f1517r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1518s;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.getCapType().toPaintCap(), shapeStroke.getJoinType().toPaintJoin(), shapeStroke.getMiterLimit(), shapeStroke.getOpacity(), shapeStroke.getWidth(), shapeStroke.getLineDashPattern(), shapeStroke.getDashOffset());
        this.f1514o = baseLayer;
        this.f1515p = shapeStroke.getName();
        this.f1516q = shapeStroke.isHidden();
        BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeStroke.getColor().createAnimation();
        this.f1517r = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t3, lottieValueCallback);
        if (t3 == LottieProperty.STROKE_COLOR) {
            this.f1517r.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1518s;
            if (baseKeyframeAnimation != null) {
                this.f1514o.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f1518s = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1518s = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.f1514o.addAnimation(this.f1517r);
        }
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i4) {
        if (this.f1516q) {
            return;
        }
        this.f1398i.setColor(((ColorKeyframeAnimation) this.f1517r).getIntValue());
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1518s;
        if (baseKeyframeAnimation != null) {
            this.f1398i.setColorFilter(baseKeyframeAnimation.getValue());
        }
        super.draw(canvas, matrix, i4);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1515p;
    }
}
