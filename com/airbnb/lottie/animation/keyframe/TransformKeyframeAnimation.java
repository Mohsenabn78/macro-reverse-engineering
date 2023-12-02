package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

/* loaded from: classes2.dex */
public class TransformKeyframeAnimation {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f1560a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f1561b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f1562c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f1563d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f1564e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private BaseKeyframeAnimation<PointF, PointF> f1565f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private BaseKeyframeAnimation<?, PointF> f1566g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private BaseKeyframeAnimation<ScaleXY, ScaleXY> f1567h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private BaseKeyframeAnimation<Float, Float> f1568i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private BaseKeyframeAnimation<Integer, Integer> f1569j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private FloatKeyframeAnimation f1570k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private FloatKeyframeAnimation f1571l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private BaseKeyframeAnimation<?, Float> f1572m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private BaseKeyframeAnimation<?, Float> f1573n;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        BaseKeyframeAnimation<PointF, PointF> createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> createAnimation3;
        BaseKeyframeAnimation<Float, Float> createAnimation4;
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        if (animatableTransform.getAnchorPoint() == null) {
            createAnimation = null;
        } else {
            createAnimation = animatableTransform.getAnchorPoint().createAnimation();
        }
        this.f1565f = createAnimation;
        if (animatableTransform.getPosition() == null) {
            createAnimation2 = null;
        } else {
            createAnimation2 = animatableTransform.getPosition().createAnimation();
        }
        this.f1566g = createAnimation2;
        if (animatableTransform.getScale() == null) {
            createAnimation3 = null;
        } else {
            createAnimation3 = animatableTransform.getScale().createAnimation();
        }
        this.f1567h = createAnimation3;
        if (animatableTransform.getRotation() == null) {
            createAnimation4 = null;
        } else {
            createAnimation4 = animatableTransform.getRotation().createAnimation();
        }
        this.f1568i = createAnimation4;
        if (animatableTransform.getSkew() == null) {
            floatKeyframeAnimation = null;
        } else {
            floatKeyframeAnimation = (FloatKeyframeAnimation) animatableTransform.getSkew().createAnimation();
        }
        this.f1570k = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.f1561b = new Matrix();
            this.f1562c = new Matrix();
            this.f1563d = new Matrix();
            this.f1564e = new float[9];
        } else {
            this.f1561b = null;
            this.f1562c = null;
            this.f1563d = null;
            this.f1564e = null;
        }
        if (animatableTransform.getSkewAngle() == null) {
            floatKeyframeAnimation2 = null;
        } else {
            floatKeyframeAnimation2 = (FloatKeyframeAnimation) animatableTransform.getSkewAngle().createAnimation();
        }
        this.f1571l = floatKeyframeAnimation2;
        if (animatableTransform.getOpacity() != null) {
            this.f1569j = animatableTransform.getOpacity().createAnimation();
        }
        if (animatableTransform.getStartOpacity() != null) {
            this.f1572m = animatableTransform.getStartOpacity().createAnimation();
        } else {
            this.f1572m = null;
        }
        if (animatableTransform.getEndOpacity() != null) {
            this.f1573n = animatableTransform.getEndOpacity().createAnimation();
        } else {
            this.f1573n = null;
        }
    }

    private void a() {
        for (int i4 = 0; i4 < 9; i4++) {
            this.f1564e[i4] = 0.0f;
        }
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        baseLayer.addAnimation(this.f1569j);
        baseLayer.addAnimation(this.f1572m);
        baseLayer.addAnimation(this.f1573n);
        baseLayer.addAnimation(this.f1565f);
        baseLayer.addAnimation(this.f1566g);
        baseLayer.addAnimation(this.f1567h);
        baseLayer.addAnimation(this.f1568i);
        baseLayer.addAnimation(this.f1570k);
        baseLayer.addAnimation(this.f1571l);
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f1569j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f1572m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f1573n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f1565f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f1566g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.f1567h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f1568i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f1570k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f1571l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.addUpdateListener(animationListener);
        }
    }

    public <T> boolean applyValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t3 == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.f1565f;
            if (baseKeyframeAnimation3 == null) {
                this.f1565f = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation3.setValueCallback(lottieValueCallback);
            return true;
        } else if (t3 == LottieProperty.TRANSFORM_POSITION) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.f1566g;
            if (baseKeyframeAnimation4 == null) {
                this.f1566g = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation4.setValueCallback(lottieValueCallback);
            return true;
        } else {
            if (t3 == LottieProperty.TRANSFORM_POSITION_X) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f1566g;
                if (baseKeyframeAnimation5 instanceof SplitDimensionPathKeyframeAnimation) {
                    ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation5).setXValueCallback(lottieValueCallback);
                    return true;
                }
            }
            if (t3 == LottieProperty.TRANSFORM_POSITION_Y) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation6 = this.f1566g;
                if (baseKeyframeAnimation6 instanceof SplitDimensionPathKeyframeAnimation) {
                    ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation6).setYValueCallback(lottieValueCallback);
                    return true;
                }
            }
            if (t3 == LottieProperty.TRANSFORM_SCALE) {
                BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation7 = this.f1567h;
                if (baseKeyframeAnimation7 == null) {
                    this.f1567h = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                    return true;
                }
                baseKeyframeAnimation7.setValueCallback(lottieValueCallback);
                return true;
            } else if (t3 == LottieProperty.TRANSFORM_ROTATION) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation8 = this.f1568i;
                if (baseKeyframeAnimation8 == null) {
                    this.f1568i = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                    return true;
                }
                baseKeyframeAnimation8.setValueCallback(lottieValueCallback);
                return true;
            } else if (t3 == LottieProperty.TRANSFORM_OPACITY) {
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation9 = this.f1569j;
                if (baseKeyframeAnimation9 == null) {
                    this.f1569j = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                    return true;
                }
                baseKeyframeAnimation9.setValueCallback(lottieValueCallback);
                return true;
            } else if (t3 == LottieProperty.TRANSFORM_START_OPACITY && (baseKeyframeAnimation2 = this.f1572m) != null) {
                if (baseKeyframeAnimation2 == null) {
                    this.f1572m = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                    return true;
                }
                baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
                return true;
            } else if (t3 == LottieProperty.TRANSFORM_END_OPACITY && (baseKeyframeAnimation = this.f1573n) != null) {
                if (baseKeyframeAnimation == null) {
                    this.f1573n = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                    return true;
                }
                baseKeyframeAnimation.setValueCallback(lottieValueCallback);
                return true;
            } else if (t3 == LottieProperty.TRANSFORM_SKEW && (floatKeyframeAnimation2 = this.f1570k) != null) {
                if (floatKeyframeAnimation2 == null) {
                    this.f1570k = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                }
                this.f1570k.setValueCallback(lottieValueCallback);
                return true;
            } else if (t3 == LottieProperty.TRANSFORM_SKEW_ANGLE && (floatKeyframeAnimation = this.f1571l) != null) {
                if (floatKeyframeAnimation == null) {
                    this.f1571l = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                }
                this.f1571l.setValueCallback(lottieValueCallback);
                return true;
            } else {
                return false;
            }
        }
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> getEndOpacity() {
        return this.f1573n;
    }

    public Matrix getMatrix() {
        float cos;
        float sin;
        float floatValue;
        this.f1560a.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f1566g;
        if (baseKeyframeAnimation != null) {
            PointF value = baseKeyframeAnimation.getValue();
            float f4 = value.x;
            if (f4 != 0.0f || value.y != 0.0f) {
                this.f1560a.preTranslate(f4, value.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f1568i;
        if (baseKeyframeAnimation2 != null) {
            if (baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation) {
                floatValue = baseKeyframeAnimation2.getValue().floatValue();
            } else {
                floatValue = ((FloatKeyframeAnimation) baseKeyframeAnimation2).getFloatValue();
            }
            if (floatValue != 0.0f) {
                this.f1560a.preRotate(floatValue);
            }
        }
        if (this.f1570k != null) {
            FloatKeyframeAnimation floatKeyframeAnimation = this.f1571l;
            if (floatKeyframeAnimation == null) {
                cos = 0.0f;
            } else {
                cos = (float) Math.cos(Math.toRadians((-floatKeyframeAnimation.getFloatValue()) + 90.0f));
            }
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.f1571l;
            if (floatKeyframeAnimation2 == null) {
                sin = 1.0f;
            } else {
                sin = (float) Math.sin(Math.toRadians((-floatKeyframeAnimation2.getFloatValue()) + 90.0f));
            }
            a();
            float[] fArr = this.f1564e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f5 = -sin;
            fArr[3] = f5;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f1561b.setValues(fArr);
            a();
            float[] fArr2 = this.f1564e;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians(this.f1570k.getFloatValue()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f1562c.setValues(fArr2);
            a();
            float[] fArr3 = this.f1564e;
            fArr3[0] = cos;
            fArr3[1] = f5;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f1563d.setValues(fArr3);
            this.f1562c.preConcat(this.f1561b);
            this.f1563d.preConcat(this.f1562c);
            this.f1560a.preConcat(this.f1563d);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.f1567h;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY value2 = baseKeyframeAnimation3.getValue();
            if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
                this.f1560a.preScale(value2.getScaleX(), value2.getScaleY());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f1565f;
        if (baseKeyframeAnimation4 != null) {
            PointF value3 = baseKeyframeAnimation4.getValue();
            float f6 = value3.x;
            if (f6 != 0.0f || value3.y != 0.0f) {
                this.f1560a.preTranslate(-f6, -value3.y);
            }
        }
        return this.f1560a;
    }

    public Matrix getMatrixForRepeater(float f4) {
        PointF value;
        ScaleXY value2;
        float f5;
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f1566g;
        PointF pointF = null;
        if (baseKeyframeAnimation == null) {
            value = null;
        } else {
            value = baseKeyframeAnimation.getValue();
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.f1567h;
        if (baseKeyframeAnimation2 == null) {
            value2 = null;
        } else {
            value2 = baseKeyframeAnimation2.getValue();
        }
        this.f1560a.reset();
        if (value != null) {
            this.f1560a.preTranslate(value.x * f4, value.y * f4);
        }
        if (value2 != null) {
            double d4 = f4;
            this.f1560a.preScale((float) Math.pow(value2.getScaleX(), d4), (float) Math.pow(value2.getScaleY(), d4));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.f1568i;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.getValue().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f1565f;
            if (baseKeyframeAnimation4 != null) {
                pointF = baseKeyframeAnimation4.getValue();
            }
            Matrix matrix = this.f1560a;
            float f6 = floatValue * f4;
            float f7 = 0.0f;
            if (pointF == null) {
                f5 = 0.0f;
            } else {
                f5 = pointF.x;
            }
            if (pointF != null) {
                f7 = pointF.y;
            }
            matrix.preRotate(f6, f5, f7);
        }
        return this.f1560a;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Integer> getOpacity() {
        return this.f1569j;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> getStartOpacity() {
        return this.f1572m;
    }

    public void setProgress(float f4) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f1569j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.setProgress(f4);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f1572m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.setProgress(f4);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f1573n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.setProgress(f4);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f1565f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.setProgress(f4);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f1566g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.setProgress(f4);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.f1567h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.setProgress(f4);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f1568i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.setProgress(f4);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f1570k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f4);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f1571l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.setProgress(f4);
        }
    }
}
