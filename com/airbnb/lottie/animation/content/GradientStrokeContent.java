package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes2.dex */
public class GradientStrokeContent extends BaseStrokeContent {

    /* renamed from: o  reason: collision with root package name */
    private final String f1454o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f1455p;

    /* renamed from: q  reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f1456q;

    /* renamed from: r  reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f1457r;

    /* renamed from: s  reason: collision with root package name */
    private final RectF f1458s;

    /* renamed from: t  reason: collision with root package name */
    private final GradientType f1459t;

    /* renamed from: u  reason: collision with root package name */
    private final int f1460u;

    /* renamed from: v  reason: collision with root package name */
    private final BaseKeyframeAnimation<GradientColor, GradientColor> f1461v;

    /* renamed from: w  reason: collision with root package name */
    private final BaseKeyframeAnimation<PointF, PointF> f1462w;

    /* renamed from: x  reason: collision with root package name */
    private final BaseKeyframeAnimation<PointF, PointF> f1463x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private ValueCallbackKeyframeAnimation f1464y;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.getCapType().toPaintCap(), gradientStroke.getJoinType().toPaintJoin(), gradientStroke.getMiterLimit(), gradientStroke.getOpacity(), gradientStroke.getWidth(), gradientStroke.getLineDashPattern(), gradientStroke.getDashOffset());
        this.f1456q = new LongSparseArray<>();
        this.f1457r = new LongSparseArray<>();
        this.f1458s = new RectF();
        this.f1454o = gradientStroke.getName();
        this.f1459t = gradientStroke.getGradientType();
        this.f1455p = gradientStroke.isHidden();
        this.f1460u = (int) (lottieDrawable.getComposition().getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation = gradientStroke.getGradientColor().createAnimation();
        this.f1461v = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = gradientStroke.getStartPoint().createAnimation();
        this.f1462w = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation2);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = gradientStroke.getEndPoint().createAnimation();
        this.f1463x = createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation3);
    }

    private int[] c(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f1464y;
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

    private int d() {
        int i4;
        int round = Math.round(this.f1462w.getProgress() * this.f1460u);
        int round2 = Math.round(this.f1463x.getProgress() * this.f1460u);
        int round3 = Math.round(this.f1461v.getProgress() * this.f1460u);
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

    private LinearGradient e() {
        long d4 = d();
        LinearGradient linearGradient = this.f1456q.get(d4);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF value = this.f1462w.getValue();
        PointF value2 = this.f1463x.getValue();
        GradientColor value3 = this.f1461v.getValue();
        LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, c(value3.getColors()), value3.getPositions(), Shader.TileMode.CLAMP);
        this.f1456q.put(d4, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient f() {
        float f4;
        float f5;
        long d4 = d();
        RadialGradient radialGradient = this.f1457r.get(d4);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF value = this.f1462w.getValue();
        PointF value2 = this.f1463x.getValue();
        GradientColor value3 = this.f1461v.getValue();
        int[] c4 = c(value3.getColors());
        float[] positions = value3.getPositions();
        RadialGradient radialGradient2 = new RadialGradient(value.x, value.y, (float) Math.hypot(value2.x - f4, value2.y - f5), c4, positions, Shader.TileMode.CLAMP);
        this.f1457r.put(d4, radialGradient2);
        return radialGradient2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t3, lottieValueCallback);
        if (t3 == LottieProperty.GRADIENT_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f1464y;
            if (valueCallbackKeyframeAnimation != null) {
                this.f1395f.removeAnimation(valueCallbackKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f1464y = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1464y = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            this.f1395f.addAnimation(this.f1464y);
        }
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i4) {
        Shader f4;
        if (this.f1455p) {
            return;
        }
        getBounds(this.f1458s, matrix, false);
        if (this.f1459t == GradientType.LINEAR) {
            f4 = e();
        } else {
            f4 = f();
        }
        f4.setLocalMatrix(matrix);
        this.f1398i.setShader(f4);
        super.draw(canvas, matrix, i4);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1454o;
    }
}
