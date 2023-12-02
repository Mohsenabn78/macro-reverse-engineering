package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: a  reason: collision with root package name */
    private final Path f1426a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1427b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseLayer f1428c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1429d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1430e;

    /* renamed from: f  reason: collision with root package name */
    private final List<b> f1431f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f1432g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f1433h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1434i;

    /* renamed from: j  reason: collision with root package name */
    private final LottieDrawable f1435j;

    public FillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeFill shapeFill) {
        Path path = new Path();
        this.f1426a = path;
        this.f1427b = new LPaint(1);
        this.f1431f = new ArrayList();
        this.f1428c = baseLayer;
        this.f1429d = shapeFill.getName();
        this.f1430e = shapeFill.isHidden();
        this.f1435j = lottieDrawable;
        if (shapeFill.getColor() != null && shapeFill.getOpacity() != null) {
            path.setFillType(shapeFill.getFillType());
            BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeFill.getColor().createAnimation();
            this.f1432g = createAnimation;
            createAnimation.addUpdateListener(this);
            baseLayer.addAnimation(createAnimation);
            BaseKeyframeAnimation<Integer, Integer> createAnimation2 = shapeFill.getOpacity().createAnimation();
            this.f1433h = createAnimation2;
            createAnimation2.addUpdateListener(this);
            baseLayer.addAnimation(createAnimation2);
            return;
        }
        this.f1432g = null;
        this.f1433h = null;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t3 == LottieProperty.COLOR) {
            this.f1432g.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.OPACITY) {
            this.f1433h.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1434i;
            if (baseKeyframeAnimation != null) {
                this.f1428c.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f1434i = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1434i = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.f1428c.addAnimation(this.f1434i);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i4) {
        if (this.f1430e) {
            return;
        }
        L.beginSection("FillContent#draw");
        this.f1427b.setColor(((ColorKeyframeAnimation) this.f1432g).getIntValue());
        this.f1427b.setAlpha(MiscUtils.clamp((int) ((((i4 / 255.0f) * this.f1433h.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1434i;
        if (baseKeyframeAnimation != null) {
            this.f1427b.setColorFilter(baseKeyframeAnimation.getValue());
        }
        this.f1426a.reset();
        for (int i5 = 0; i5 < this.f1431f.size(); i5++) {
            this.f1426a.addPath(this.f1431f.get(i5).getPath(), matrix);
        }
        canvas.drawPath(this.f1426a, this.f1427b);
        L.endSection("FillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z3) {
        this.f1426a.reset();
        for (int i4 = 0; i4 < this.f1431f.size(); i4++) {
            this.f1426a.addPath(this.f1431f.get(i4).getPath(), matrix);
        }
        this.f1426a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1429d;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.f1435j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i4, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i4, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i4 = 0; i4 < list2.size(); i4++) {
            Content content = list2.get(i4);
            if (content instanceof b) {
                this.f1431f.add((b) content);
            }
        }
    }
}
