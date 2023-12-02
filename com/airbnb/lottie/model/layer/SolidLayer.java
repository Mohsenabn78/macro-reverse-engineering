package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes2.dex */
public class SolidLayer extends BaseLayer {
    private final Paint A;
    private final float[] B;
    private final Path C;
    private final Layer D;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> E;

    /* renamed from: z  reason: collision with root package name */
    private final RectF f1776z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.f1776z = new RectF();
        LPaint lPaint = new LPaint();
        this.A = lPaint;
        this.B = new float[8];
        this.C = new Path();
        this.D = layer;
        lPaint.setAlpha(0);
        lPaint.setStyle(Paint.Style.FILL);
        lPaint.setColor(layer.k());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t3, lottieValueCallback);
        if (t3 == LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.E = null;
            } else {
                this.E = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i4) {
        int intValue;
        int alpha = Color.alpha(this.D.k());
        if (alpha == 0) {
            return;
        }
        if (this.f1741v.getOpacity() == null) {
            intValue = 100;
        } else {
            intValue = this.f1741v.getOpacity().getValue().intValue();
        }
        int i5 = (int) ((i4 / 255.0f) * (((alpha / 255.0f) * intValue) / 100.0f) * 255.0f);
        this.A.setAlpha(i5);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.E;
        if (baseKeyframeAnimation != null) {
            this.A.setColorFilter(baseKeyframeAnimation.getValue());
        }
        if (i5 > 0) {
            float[] fArr = this.B;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.D.m();
            float[] fArr2 = this.B;
            fArr2[3] = 0.0f;
            fArr2[4] = this.D.m();
            this.B[5] = this.D.l();
            float[] fArr3 = this.B;
            fArr3[6] = 0.0f;
            fArr3[7] = this.D.l();
            matrix.mapPoints(this.B);
            this.C.reset();
            Path path = this.C;
            float[] fArr4 = this.B;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.C;
            float[] fArr5 = this.B;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.C;
            float[] fArr6 = this.B;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.C;
            float[] fArr7 = this.B;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.C;
            float[] fArr8 = this.B;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.C.close();
            canvas.drawPath(this.C, this.A);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z3) {
        super.getBounds(rectF, matrix, z3);
        this.f1776z.set(0.0f, 0.0f, this.D.m(), this.D.l());
        this.f1732m.mapRect(this.f1776z);
        rectF.set(this.f1776z);
    }
}
