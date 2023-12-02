package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f1436a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1437b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseLayer f1438c;

    /* renamed from: d  reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f1439d = new LongSparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f1440e = new LongSparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private final Path f1441f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f1442g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f1443h;

    /* renamed from: i  reason: collision with root package name */
    private final List<b> f1444i;

    /* renamed from: j  reason: collision with root package name */
    private final GradientType f1445j;

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<GradientColor, GradientColor> f1446k;

    /* renamed from: l  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f1447l;

    /* renamed from: m  reason: collision with root package name */
    private final BaseKeyframeAnimation<PointF, PointF> f1448m;

    /* renamed from: n  reason: collision with root package name */
    private final BaseKeyframeAnimation<PointF, PointF> f1449n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1450o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private ValueCallbackKeyframeAnimation f1451p;

    /* renamed from: q  reason: collision with root package name */
    private final LottieDrawable f1452q;

    /* renamed from: r  reason: collision with root package name */
    private final int f1453r;

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientFill gradientFill) {
        Path path = new Path();
        this.f1441f = path;
        this.f1442g = new LPaint(1);
        this.f1443h = new RectF();
        this.f1444i = new ArrayList();
        this.f1438c = baseLayer;
        this.f1436a = gradientFill.getName();
        this.f1437b = gradientFill.isHidden();
        this.f1452q = lottieDrawable;
        this.f1445j = gradientFill.getGradientType();
        path.setFillType(gradientFill.getFillType());
        this.f1453r = (int) (lottieDrawable.getComposition().getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation = gradientFill.getGradientColor().createAnimation();
        this.f1446k = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
        BaseKeyframeAnimation<Integer, Integer> createAnimation2 = gradientFill.getOpacity().createAnimation();
        this.f1447l = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation2);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = gradientFill.getStartPoint().createAnimation();
        this.f1448m = createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation3);
        BaseKeyframeAnimation<PointF, PointF> createAnimation4 = gradientFill.getEndPoint().createAnimation();
        this.f1449n = createAnimation4;
        createAnimation4.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation4);
    }

    private int[] a(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f1451p;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.getValue();
            int i4 = 0;
            if (iArr.length == numArr.length) {
                while (i4 < iArr.length) {
                    iArr[i4] = numArr[i4].intValue();
                    i4++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i4 < numArr.length) {
                    iArr[i4] = numArr[i4].intValue();
                    i4++;
                }
            }
        }
        return iArr;
    }

    private int b() {
        int i4;
        int round = Math.round(this.f1448m.getProgress() * this.f1453r);
        int round2 = Math.round(this.f1449n.getProgress() * this.f1453r);
        int round3 = Math.round(this.f1446k.getProgress() * this.f1453r);
        if (round != 0) {
            i4 = 527 * round;
        } else {
            i4 = 17;
        }
        if (round2 != 0) {
            i4 = i4 * 31 * round2;
        }
        if (round3 != 0) {
            return i4 * 31 * round3;
        }
        return i4;
    }

    private LinearGradient c() {
        long b4 = b();
        LinearGradient linearGradient = this.f1439d.get(b4);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF value = this.f1448m.getValue();
        PointF value2 = this.f1449n.getValue();
        GradientColor value3 = this.f1446k.getValue();
        LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, a(value3.getColors()), value3.getPositions(), Shader.TileMode.CLAMP);
        this.f1439d.put(b4, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        float f4;
        long b4 = b();
        RadialGradient radialGradient = this.f1440e.get(b4);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF value = this.f1448m.getValue();
        PointF value2 = this.f1449n.getValue();
        GradientColor value3 = this.f1446k.getValue();
        int[] a4 = a(value3.getColors());
        float[] positions = value3.getPositions();
        float f5 = value.x;
        float f6 = value.y;
        float hypot = (float) Math.hypot(value2.x - f5, value2.y - f6);
        if (hypot <= 0.0f) {
            f4 = 0.001f;
        } else {
            f4 = hypot;
        }
        RadialGradient radialGradient2 = new RadialGradient(f5, f6, f4, a4, positions, Shader.TileMode.CLAMP);
        this.f1440e.put(b4, radialGradient2);
        return radialGradient2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t3 == LottieProperty.OPACITY) {
            this.f1447l.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1450o;
            if (baseKeyframeAnimation != null) {
                this.f1438c.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f1450o = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1450o = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.f1438c.addAnimation(this.f1450o);
        } else if (t3 == LottieProperty.GRADIENT_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.f1451p;
            if (valueCallbackKeyframeAnimation2 != null) {
                this.f1438c.removeAnimation(valueCallbackKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.f1451p = null;
                return;
            }
            this.f1439d.clear();
            this.f1440e.clear();
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1451p = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
            this.f1438c.addAnimation(this.f1451p);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i4) {
        Shader d4;
        if (this.f1437b) {
            return;
        }
        L.beginSection("GradientFillContent#draw");
        this.f1441f.reset();
        for (int i5 = 0; i5 < this.f1444i.size(); i5++) {
            this.f1441f.addPath(this.f1444i.get(i5).getPath(), matrix);
        }
        this.f1441f.computeBounds(this.f1443h, false);
        if (this.f1445j == GradientType.LINEAR) {
            d4 = c();
        } else {
            d4 = d();
        }
        d4.setLocalMatrix(matrix);
        this.f1442g.setShader(d4);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1450o;
        if (baseKeyframeAnimation != null) {
            this.f1442g.setColorFilter(baseKeyframeAnimation.getValue());
        }
        this.f1442g.setAlpha(MiscUtils.clamp((int) ((((i4 / 255.0f) * this.f1447l.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f1441f, this.f1442g);
        L.endSection("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z3) {
        this.f1441f.reset();
        for (int i4 = 0; i4 < this.f1444i.size(); i4++) {
            this.f1441f.addPath(this.f1444i.get(i4).getPath(), matrix);
        }
        this.f1441f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1436a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.f1452q.invalidateSelf();
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
                this.f1444i.add((b) content);
            }
        }
    }
}
