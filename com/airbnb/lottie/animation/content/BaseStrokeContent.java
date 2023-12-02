package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {

    /* renamed from: e  reason: collision with root package name */
    private final LottieDrawable f1394e;

    /* renamed from: f  reason: collision with root package name */
    protected final BaseLayer f1395f;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f1397h;

    /* renamed from: i  reason: collision with root package name */
    final Paint f1398i;

    /* renamed from: j  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1399j;

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Integer> f1400k;

    /* renamed from: l  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<?, Float>> f1401l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1402m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1403n;

    /* renamed from: a  reason: collision with root package name */
    private final PathMeasure f1390a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private final Path f1391b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f1392c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f1393d = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final List<b> f1396g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.airbnb.lottie.animation.content.b> f1404a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final TrimPathContent f1405b;

        private b(@Nullable TrimPathContent trimPathContent) {
            this.f1404a = new ArrayList();
            this.f1405b = trimPathContent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f4, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.f1398i = lPaint;
        this.f1394e = lottieDrawable;
        this.f1395f = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f4);
        this.f1400k = animatableIntegerValue.createAnimation();
        this.f1399j = animatableFloatValue.createAnimation();
        if (animatableFloatValue2 == null) {
            this.f1402m = null;
        } else {
            this.f1402m = animatableFloatValue2.createAnimation();
        }
        this.f1401l = new ArrayList(list.size());
        this.f1397h = new float[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f1401l.add(list.get(i4).createAnimation());
        }
        baseLayer.addAnimation(this.f1400k);
        baseLayer.addAnimation(this.f1399j);
        for (int i5 = 0; i5 < this.f1401l.size(); i5++) {
            baseLayer.addAnimation(this.f1401l.get(i5));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f1402m;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        this.f1400k.addUpdateListener(this);
        this.f1399j.addUpdateListener(this);
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.f1401l.get(i6).addUpdateListener(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f1402m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(this);
        }
    }

    private void a(Matrix matrix) {
        float floatValue;
        L.beginSection("StrokeContent#applyDashPattern");
        if (this.f1401l.isEmpty()) {
            L.endSection("StrokeContent#applyDashPattern");
            return;
        }
        float scale = Utils.getScale(matrix);
        for (int i4 = 0; i4 < this.f1401l.size(); i4++) {
            this.f1397h[i4] = this.f1401l.get(i4).getValue().floatValue();
            if (i4 % 2 == 0) {
                float[] fArr = this.f1397h;
                if (fArr[i4] < 1.0f) {
                    fArr[i4] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f1397h;
                if (fArr2[i4] < 0.1f) {
                    fArr2[i4] = 0.1f;
                }
            }
            float[] fArr3 = this.f1397h;
            fArr3[i4] = fArr3[i4] * scale;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f1402m;
        if (baseKeyframeAnimation == null) {
            floatValue = 0.0f;
        } else {
            floatValue = scale * baseKeyframeAnimation.getValue().floatValue();
        }
        this.f1398i.setPathEffect(new DashPathEffect(this.f1397h, floatValue));
        L.endSection("StrokeContent#applyDashPattern");
    }

    private void b(Canvas canvas, b bVar, Matrix matrix) {
        float f4;
        float f5;
        L.beginSection("StrokeContent#applyTrimPath");
        if (bVar.f1405b == null) {
            L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        this.f1391b.reset();
        for (int size = bVar.f1404a.size() - 1; size >= 0; size--) {
            this.f1391b.addPath(((com.airbnb.lottie.animation.content.b) bVar.f1404a.get(size)).getPath(), matrix);
        }
        this.f1390a.setPath(this.f1391b, false);
        float length = this.f1390a.getLength();
        while (this.f1390a.nextContour()) {
            length += this.f1390a.getLength();
        }
        float floatValue = (bVar.f1405b.getOffset().getValue().floatValue() * length) / 360.0f;
        float floatValue2 = ((bVar.f1405b.getStart().getValue().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((bVar.f1405b.getEnd().getValue().floatValue() * length) / 100.0f) + floatValue;
        float f6 = 0.0f;
        for (int size2 = bVar.f1404a.size() - 1; size2 >= 0; size2--) {
            this.f1392c.set(((com.airbnb.lottie.animation.content.b) bVar.f1404a.get(size2)).getPath());
            this.f1392c.transform(matrix);
            this.f1390a.setPath(this.f1392c, false);
            float length2 = this.f1390a.getLength();
            float f7 = 1.0f;
            if (floatValue3 > length) {
                float f8 = floatValue3 - length;
                if (f8 < f6 + length2 && f6 < f8) {
                    if (floatValue2 > length) {
                        f5 = (floatValue2 - length) / length2;
                    } else {
                        f5 = 0.0f;
                    }
                    Utils.applyTrimPathIfNeeded(this.f1392c, f5, Math.min(f8 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f1392c, this.f1398i);
                    f6 += length2;
                }
            }
            float f9 = f6 + length2;
            if (f9 >= floatValue2 && f6 <= floatValue3) {
                if (f9 <= floatValue3 && floatValue2 < f6) {
                    canvas.drawPath(this.f1392c, this.f1398i);
                } else {
                    if (floatValue2 < f6) {
                        f4 = 0.0f;
                    } else {
                        f4 = (floatValue2 - f6) / length2;
                    }
                    if (floatValue3 <= f9) {
                        f7 = (floatValue3 - f6) / length2;
                    }
                    Utils.applyTrimPathIfNeeded(this.f1392c, f4, f7, 0.0f);
                    canvas.drawPath(this.f1392c, this.f1398i);
                }
            }
            f6 += length2;
        }
        L.endSection("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t3 == LottieProperty.OPACITY) {
            this.f1400k.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.STROKE_WIDTH) {
            this.f1399j.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1403n;
            if (baseKeyframeAnimation != null) {
                this.f1395f.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f1403n = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1403n = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.f1395f.addAnimation(this.f1403n);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i4) {
        L.beginSection("StrokeContent#draw");
        if (Utils.hasZeroScaleAxis(matrix)) {
            L.endSection("StrokeContent#draw");
            return;
        }
        this.f1398i.setAlpha(MiscUtils.clamp((int) ((((i4 / 255.0f) * ((IntegerKeyframeAnimation) this.f1400k).getIntValue()) / 100.0f) * 255.0f), 0, 255));
        this.f1398i.setStrokeWidth(((FloatKeyframeAnimation) this.f1399j).getFloatValue() * Utils.getScale(matrix));
        if (this.f1398i.getStrokeWidth() <= 0.0f) {
            L.endSection("StrokeContent#draw");
            return;
        }
        a(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1403n;
        if (baseKeyframeAnimation != null) {
            this.f1398i.setColorFilter(baseKeyframeAnimation.getValue());
        }
        for (int i5 = 0; i5 < this.f1396g.size(); i5++) {
            b bVar = this.f1396g.get(i5);
            if (bVar.f1405b != null) {
                b(canvas, bVar, matrix);
            } else {
                L.beginSection("StrokeContent#buildPath");
                this.f1391b.reset();
                for (int size = bVar.f1404a.size() - 1; size >= 0; size--) {
                    this.f1391b.addPath(((com.airbnb.lottie.animation.content.b) bVar.f1404a.get(size)).getPath(), matrix);
                }
                L.endSection("StrokeContent#buildPath");
                L.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.f1391b, this.f1398i);
                L.endSection("StrokeContent#drawPath");
            }
        }
        L.endSection("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z3) {
        L.beginSection("StrokeContent#getBounds");
        this.f1391b.reset();
        for (int i4 = 0; i4 < this.f1396g.size(); i4++) {
            b bVar = this.f1396g.get(i4);
            for (int i5 = 0; i5 < bVar.f1404a.size(); i5++) {
                this.f1391b.addPath(((com.airbnb.lottie.animation.content.b) bVar.f1404a.get(i5)).getPath(), matrix);
            }
        }
        this.f1391b.computeBounds(this.f1393d, false);
        float floatValue = ((FloatKeyframeAnimation) this.f1399j).getFloatValue();
        RectF rectF2 = this.f1393d;
        float f4 = floatValue / 2.0f;
        rectF2.set(rectF2.left - f4, rectF2.top - f4, rectF2.right + f4, rectF2.bottom + f4);
        rectF.set(this.f1393d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.endSection("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.f1394e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i4, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i4, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.b() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.a(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.b() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f1396g.add(bVar);
                    }
                    bVar = new b(trimPathContent3);
                    trimPathContent3.a(this);
                }
            }
            if (content2 instanceof com.airbnb.lottie.animation.content.b) {
                if (bVar == null) {
                    bVar = new b(trimPathContent);
                }
                bVar.f1404a.add((com.airbnb.lottie.animation.content.b) content2);
            }
        }
        if (bVar != null) {
            this.f1396g.add(bVar);
        }
    }
}
