package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CompositionLayer extends BaseLayer {
    private final List<BaseLayer> A;
    private final RectF B;
    private final RectF C;
    private Paint D;
    @Nullable
    private Boolean E;
    @Nullable
    private Boolean F;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    private BaseKeyframeAnimation<Float, Float> f1748z;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1749a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f1749a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1749a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        int i4;
        BaseLayer baseLayer;
        this.A = new ArrayList();
        this.B = new RectF();
        this.C = new RectF();
        this.D = new Paint();
        AnimatableFloatValue q4 = layer.q();
        if (q4 != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = q4.createAnimation();
            this.f1748z = createAnimation;
            addAnimation(createAnimation);
            this.f1748z.addUpdateListener(this);
        } else {
            this.f1748z = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.getLayers().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer m4 = BaseLayer.m(layer2, lottieDrawable, lottieComposition);
            if (m4 != null) {
                longSparseArray.put(m4.n().getId(), m4);
                if (baseLayer2 != null) {
                    baseLayer2.v(m4);
                    baseLayer2 = null;
                } else {
                    this.A.add(0, m4);
                    int i5 = a.f1749a[layer2.d().ordinal()];
                    if (i5 == 1 || i5 == 2) {
                        baseLayer2 = m4;
                    }
                }
            }
            size--;
        }
        for (i4 = 0; i4 < longSparseArray.size(); i4++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(i4));
            if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.get(baseLayer3.n().f())) != null) {
                baseLayer3.w(baseLayer);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t3, lottieValueCallback);
        if (t3 == LottieProperty.TIME_REMAP) {
            if (lottieValueCallback == null) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.f1748z;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.setValueCallback(null);
                    return;
                }
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1748z = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            addAnimation(this.f1748z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(Canvas canvas, Matrix matrix, int i4) {
        boolean z3;
        boolean z4;
        L.beginSection("CompositionLayer#draw");
        this.C.set(0.0f, 0.0f, this.f1734o.h(), this.f1734o.g());
        matrix.mapRect(this.C);
        if (this.f1733n.isApplyingOpacityToLayersEnabled() && this.A.size() > 1 && i4 != 255) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            this.D.setAlpha(i4);
            Utils.saveLayerCompat(canvas, this.C, this.D);
        } else {
            canvas.save();
        }
        if (z3) {
            i4 = 255;
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            if (!this.C.isEmpty()) {
                z4 = canvas.clipRect(this.C);
            } else {
                z4 = true;
            }
            if (z4) {
                this.A.get(size).draw(canvas, matrix, i4);
            }
        }
        canvas.restore();
        L.endSection("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z3) {
        super.getBounds(rectF, matrix, z3);
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.B.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.A.get(size).getBounds(this.B, this.f1732m, true);
            rectF.union(this.B);
        }
    }

    public boolean hasMasks() {
        if (this.F == null) {
            for (int size = this.A.size() - 1; size >= 0; size--) {
                BaseLayer baseLayer = this.A.get(size);
                if (baseLayer instanceof ShapeLayer) {
                    if (baseLayer.o()) {
                        this.F = Boolean.TRUE;
                        return true;
                    }
                } else if ((baseLayer instanceof CompositionLayer) && ((CompositionLayer) baseLayer).hasMasks()) {
                    this.F = Boolean.TRUE;
                    return true;
                }
            }
            this.F = Boolean.FALSE;
        }
        return this.F.booleanValue();
    }

    public boolean hasMatte() {
        if (this.E == null) {
            if (p()) {
                this.E = Boolean.TRUE;
                return true;
            }
            for (int size = this.A.size() - 1; size >= 0; size--) {
                if (this.A.get(size).p()) {
                    this.E = Boolean.TRUE;
                    return true;
                }
            }
            this.E = Boolean.FALSE;
        }
        return this.E.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void setOutlineMasksAndMattes(boolean z3) {
        super.setOutlineMasksAndMattes(z3);
        for (BaseLayer baseLayer : this.A) {
            baseLayer.setOutlineMasksAndMattes(z3);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        super.setProgress(f4);
        if (this.f1748z != null) {
            f4 = ((this.f1748z.getValue().floatValue() * this.f1734o.a().getFrameRate()) - this.f1734o.a().getStartFrame()) / (this.f1733n.getComposition().getDurationFrames() + 0.01f);
        }
        if (this.f1748z == null) {
            f4 -= this.f1734o.n();
        }
        if (this.f1734o.r() != 0.0f) {
            f4 /= this.f1734o.r();
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.A.get(size).setProgress(f4);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void u(KeyPath keyPath, int i4, List<KeyPath> list, KeyPath keyPath2) {
        for (int i5 = 0; i5 < this.A.size(); i5++) {
            this.A.get(i5).resolveKeyPath(keyPath, i4, list, keyPath2);
        }
    }
}
