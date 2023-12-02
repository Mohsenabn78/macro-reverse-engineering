package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes2.dex */
public class ImageLayer extends BaseLayer {
    private final Rect A;
    private final Rect B;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> C;

    /* renamed from: z  reason: collision with root package name */
    private final Paint f1750z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.f1750z = new LPaint(3);
        this.A = new Rect();
        this.B = new Rect();
    }

    @Nullable
    private Bitmap z() {
        return this.f1733n.getImageAsset(this.f1734o.i());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t3, lottieValueCallback);
        if (t3 == LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.C = null;
            } else {
                this.C = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(@NonNull Canvas canvas, Matrix matrix, int i4) {
        Bitmap z3 = z();
        if (z3 != null && !z3.isRecycled()) {
            float dpScale = Utils.dpScale();
            this.f1750z.setAlpha(i4);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.C;
            if (baseKeyframeAnimation != null) {
                this.f1750z.setColorFilter(baseKeyframeAnimation.getValue());
            }
            canvas.save();
            canvas.concat(matrix);
            this.A.set(0, 0, z3.getWidth(), z3.getHeight());
            this.B.set(0, 0, (int) (z3.getWidth() * dpScale), (int) (z3.getHeight() * dpScale));
            canvas.drawBitmap(z3, this.A, this.B, this.f1750z);
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z3) {
        super.getBounds(rectF, matrix, z3);
        Bitmap z4 = z();
        if (z4 != null) {
            rectF.set(0.0f, 0.0f, z4.getWidth() * Utils.dpScale(), z4.getHeight() * Utils.dpScale());
            this.f1732m.mapRect(rectF);
        }
    }
}
