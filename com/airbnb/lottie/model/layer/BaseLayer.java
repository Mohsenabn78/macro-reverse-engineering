package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {

    /* renamed from: a  reason: collision with root package name */
    private final Path f1720a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f1721b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f1722c = new LPaint(1);

    /* renamed from: d  reason: collision with root package name */
    private final Paint f1723d = new LPaint(1, PorterDuff.Mode.DST_IN);

    /* renamed from: e  reason: collision with root package name */
    private final Paint f1724e = new LPaint(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: f  reason: collision with root package name */
    private final Paint f1725f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f1726g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f1727h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f1728i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f1729j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f1730k;

    /* renamed from: l  reason: collision with root package name */
    private final String f1731l;

    /* renamed from: m  reason: collision with root package name */
    final Matrix f1732m;

    /* renamed from: n  reason: collision with root package name */
    final LottieDrawable f1733n;

    /* renamed from: o  reason: collision with root package name */
    final Layer f1734o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private MaskKeyframeAnimation f1735p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private FloatKeyframeAnimation f1736q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private BaseLayer f1737r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private BaseLayer f1738s;

    /* renamed from: t  reason: collision with root package name */
    private List<BaseLayer> f1739t;

    /* renamed from: u  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<?, ?>> f1740u;

    /* renamed from: v  reason: collision with root package name */
    final TransformKeyframeAnimation f1741v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1742w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1743x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private Paint f1744y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements BaseKeyframeAnimation.AnimationListener {
        a() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
        public void onValueChanged() {
            boolean z3;
            BaseLayer baseLayer = BaseLayer.this;
            if (baseLayer.f1736q.getFloatValue() == 1.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            baseLayer.x(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1746a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1747b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f1747b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1747b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1747b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1747b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f1746a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1746a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1746a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1746a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1746a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1746a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1746a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        LPaint lPaint = new LPaint(1);
        this.f1725f = lPaint;
        this.f1726g = new LPaint(PorterDuff.Mode.CLEAR);
        this.f1727h = new RectF();
        this.f1728i = new RectF();
        this.f1729j = new RectF();
        this.f1730k = new RectF();
        this.f1732m = new Matrix();
        this.f1740u = new ArrayList();
        this.f1742w = true;
        this.f1733n = lottieDrawable;
        this.f1734o = layer;
        this.f1731l = layer.e() + "#draw";
        if (layer.d() == Layer.MatteType.INVERT) {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        TransformKeyframeAnimation createAnimation = layer.s().createAnimation();
        this.f1741v = createAnimation;
        createAnimation.addListener(this);
        if (layer.c() != null && !layer.c().isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer.c());
            this.f1735p = maskKeyframeAnimation;
            for (BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation : maskKeyframeAnimation.getMaskAnimations()) {
                baseKeyframeAnimation.addUpdateListener(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 : this.f1735p.getOpacityAnimations()) {
                addAnimation(baseKeyframeAnimation2);
                baseKeyframeAnimation2.addUpdateListener(this);
            }
        }
        y();
    }

    private void c(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.f1720a.set(baseKeyframeAnimation.getValue());
        this.f1720a.transform(matrix);
        this.f1722c.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.f1720a, this.f1722c);
    }

    private void d(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.f1727h, this.f1723d);
        this.f1720a.set(baseKeyframeAnimation.getValue());
        this.f1720a.transform(matrix);
        this.f1722c.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.f1720a, this.f1722c);
        canvas.restore();
    }

    private void e(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.f1727h, this.f1722c);
        canvas.drawRect(this.f1727h, this.f1722c);
        this.f1720a.set(baseKeyframeAnimation.getValue());
        this.f1720a.transform(matrix);
        this.f1722c.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.f1720a, this.f1724e);
        canvas.restore();
    }

    private void f(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.f1727h, this.f1723d);
        canvas.drawRect(this.f1727h, this.f1722c);
        this.f1724e.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        this.f1720a.set(baseKeyframeAnimation.getValue());
        this.f1720a.transform(matrix);
        canvas.drawPath(this.f1720a, this.f1724e);
        canvas.restore();
    }

    private void g(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.f1727h, this.f1724e);
        canvas.drawRect(this.f1727h, this.f1722c);
        this.f1724e.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        this.f1720a.set(baseKeyframeAnimation.getValue());
        this.f1720a.transform(matrix);
        canvas.drawPath(this.f1720a, this.f1724e);
        canvas.restore();
    }

    private void h(Canvas canvas, Matrix matrix) {
        L.beginSection("Layer#saveLayer");
        Utils.saveLayerCompat(canvas, this.f1727h, this.f1723d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            l(canvas);
        }
        L.endSection("Layer#saveLayer");
        for (int i4 = 0; i4 < this.f1735p.getMasks().size(); i4++) {
            Mask mask = this.f1735p.getMasks().get(i4);
            BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation = this.f1735p.getMaskAnimations().get(i4);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.f1735p.getOpacityAnimations().get(i4);
            int i5 = b.f1747b[mask.getMaskMode().ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4) {
                            if (mask.isInverted()) {
                                e(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                            } else {
                                c(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                            }
                        }
                    } else if (mask.isInverted()) {
                        f(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        d(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                } else {
                    if (i4 == 0) {
                        this.f1722c.setColor(-16777216);
                        this.f1722c.setAlpha(255);
                        canvas.drawRect(this.f1727h, this.f1722c);
                    }
                    if (mask.isInverted()) {
                        g(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        i(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                }
            } else if (j()) {
                this.f1722c.setAlpha(255);
                canvas.drawRect(this.f1727h, this.f1722c);
            }
        }
        L.beginSection("Layer#restoreLayer");
        canvas.restore();
        L.endSection("Layer#restoreLayer");
    }

    private void i(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.f1720a.set(baseKeyframeAnimation.getValue());
        this.f1720a.transform(matrix);
        canvas.drawPath(this.f1720a, this.f1724e);
    }

    private boolean j() {
        if (this.f1735p.getMaskAnimations().isEmpty()) {
            return false;
        }
        for (int i4 = 0; i4 < this.f1735p.getMasks().size(); i4++) {
            if (this.f1735p.getMasks().get(i4).getMaskMode() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void k() {
        if (this.f1739t != null) {
            return;
        }
        if (this.f1738s == null) {
            this.f1739t = Collections.emptyList();
            return;
        }
        this.f1739t = new ArrayList();
        for (BaseLayer baseLayer = this.f1738s; baseLayer != null; baseLayer = baseLayer.f1738s) {
            this.f1739t.add(baseLayer);
        }
    }

    private void l(Canvas canvas) {
        L.beginSection("Layer#clearLayer");
        RectF rectF = this.f1727h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f1726g);
        L.endSection("Layer#clearLayer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static BaseLayer m(Layer layer, LottieDrawable lottieDrawable, LottieComposition lottieComposition) {
        switch (b.f1746a[layer.getLayerType().ordinal()]) {
            case 1:
                return new ShapeLayer(lottieDrawable, layer);
            case 2:
                return new CompositionLayer(lottieDrawable, layer, lottieComposition.getPrecomps(layer.i()), lottieComposition);
            case 3:
                return new SolidLayer(lottieDrawable, layer);
            case 4:
                return new ImageLayer(lottieDrawable, layer);
            case 5:
                return new NullLayer(lottieDrawable, layer);
            case 6:
                return new TextLayer(lottieDrawable, layer);
            default:
                Logger.warning("Unknown layer type " + layer.getLayerType());
                return null;
        }
    }

    private void q(RectF rectF, Matrix matrix) {
        this.f1728i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (!o()) {
            return;
        }
        int size = this.f1735p.getMasks().size();
        for (int i4 = 0; i4 < size; i4++) {
            Mask mask = this.f1735p.getMasks().get(i4);
            this.f1720a.set(this.f1735p.getMaskAnimations().get(i4).getValue());
            this.f1720a.transform(matrix);
            int i5 = b.f1747b[mask.getMaskMode().ordinal()];
            if (i5 != 1 && i5 != 2) {
                if ((i5 == 3 || i5 == 4) && mask.isInverted()) {
                    return;
                }
                this.f1720a.computeBounds(this.f1730k, false);
                if (i4 == 0) {
                    this.f1728i.set(this.f1730k);
                } else {
                    RectF rectF2 = this.f1728i;
                    rectF2.set(Math.min(rectF2.left, this.f1730k.left), Math.min(this.f1728i.top, this.f1730k.top), Math.max(this.f1728i.right, this.f1730k.right), Math.max(this.f1728i.bottom, this.f1730k.bottom));
                }
            } else {
                return;
            }
        }
        if (!rectF.intersect(this.f1728i)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void r(RectF rectF, Matrix matrix) {
        if (!p() || this.f1734o.d() == Layer.MatteType.INVERT) {
            return;
        }
        this.f1729j.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.f1737r.getBounds(this.f1729j, matrix, true);
        if (!rectF.intersect(this.f1729j)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void s() {
        this.f1733n.invalidateSelf();
    }

    private void t(float f4) {
        this.f1733n.getComposition().getPerformanceTracker().recordRenderTime(this.f1734o.e(), f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z3) {
        if (z3 != this.f1742w) {
            this.f1742w = z3;
            s();
        }
    }

    private void y() {
        boolean z3 = true;
        if (!this.f1734o.b().isEmpty()) {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.f1734o.b());
            this.f1736q = floatKeyframeAnimation;
            floatKeyframeAnimation.setIsDiscrete();
            this.f1736q.addUpdateListener(new a());
            if (this.f1736q.getValue().floatValue() != 1.0f) {
                z3 = false;
            }
            x(z3);
            addAnimation(this.f1736q);
            return;
        }
        x(true);
    }

    public void addAnimation(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.f1740u.add(baseKeyframeAnimation);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.f1741v.applyValueCallback(t3, lottieValueCallback);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i4) {
        int intValue;
        Paint paint;
        L.beginSection(this.f1731l);
        if (this.f1742w && !this.f1734o.isHidden()) {
            k();
            L.beginSection("Layer#parentMatrix");
            this.f1721b.reset();
            this.f1721b.set(matrix);
            for (int size = this.f1739t.size() - 1; size >= 0; size--) {
                this.f1721b.preConcat(this.f1739t.get(size).f1741v.getMatrix());
            }
            L.endSection("Layer#parentMatrix");
            if (this.f1741v.getOpacity() == null) {
                intValue = 100;
            } else {
                intValue = this.f1741v.getOpacity().getValue().intValue();
            }
            int i5 = (int) ((((i4 / 255.0f) * intValue) / 100.0f) * 255.0f);
            if (!p() && !o()) {
                this.f1721b.preConcat(this.f1741v.getMatrix());
                L.beginSection("Layer#drawLayer");
                drawLayer(canvas, this.f1721b, i5);
                L.endSection("Layer#drawLayer");
                t(L.endSection(this.f1731l));
                return;
            }
            L.beginSection("Layer#computeBounds");
            getBounds(this.f1727h, this.f1721b, false);
            r(this.f1727h, matrix);
            this.f1721b.preConcat(this.f1741v.getMatrix());
            q(this.f1727h, this.f1721b);
            if (!this.f1727h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.f1727h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            L.endSection("Layer#computeBounds");
            if (this.f1727h.width() >= 1.0f && this.f1727h.height() >= 1.0f) {
                L.beginSection("Layer#saveLayer");
                this.f1722c.setAlpha(255);
                Utils.saveLayerCompat(canvas, this.f1727h, this.f1722c);
                L.endSection("Layer#saveLayer");
                l(canvas);
                L.beginSection("Layer#drawLayer");
                drawLayer(canvas, this.f1721b, i5);
                L.endSection("Layer#drawLayer");
                if (o()) {
                    h(canvas, this.f1721b);
                }
                if (p()) {
                    L.beginSection("Layer#drawMatte");
                    L.beginSection("Layer#saveLayer");
                    Utils.saveLayerCompat(canvas, this.f1727h, this.f1725f, 19);
                    L.endSection("Layer#saveLayer");
                    l(canvas);
                    this.f1737r.draw(canvas, matrix, i5);
                    L.beginSection("Layer#restoreLayer");
                    canvas.restore();
                    L.endSection("Layer#restoreLayer");
                    L.endSection("Layer#drawMatte");
                }
                L.beginSection("Layer#restoreLayer");
                canvas.restore();
                L.endSection("Layer#restoreLayer");
            }
            if (this.f1743x && (paint = this.f1744y) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.f1744y.setColor(-251901);
                this.f1744y.setStrokeWidth(4.0f);
                canvas.drawRect(this.f1727h, this.f1744y);
                this.f1744y.setStyle(Paint.Style.FILL);
                this.f1744y.setColor(1357638635);
                canvas.drawRect(this.f1727h, this.f1744y);
            }
            t(L.endSection(this.f1731l));
            return;
        }
        L.endSection(this.f1731l);
    }

    abstract void drawLayer(Canvas canvas, Matrix matrix, int i4);

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    @CallSuper
    public void getBounds(RectF rectF, Matrix matrix, boolean z3) {
        this.f1727h.set(0.0f, 0.0f, 0.0f, 0.0f);
        k();
        this.f1732m.set(matrix);
        if (z3) {
            List<BaseLayer> list = this.f1739t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f1732m.preConcat(this.f1739t.get(size).f1741v.getMatrix());
                }
            } else {
                BaseLayer baseLayer = this.f1738s;
                if (baseLayer != null) {
                    this.f1732m.preConcat(baseLayer.f1741v.getMatrix());
                }
            }
        }
        this.f1732m.preConcat(this.f1741v.getMatrix());
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1734o.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer n() {
        return this.f1734o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.f1735p;
        if (maskKeyframeAnimation != null && !maskKeyframeAnimation.getMaskAnimations().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        if (this.f1737r != null) {
            return true;
        }
        return false;
    }

    public void removeAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.f1740u.remove(baseKeyframeAnimation);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i4, List<KeyPath> list, KeyPath keyPath2) {
        BaseLayer baseLayer = this.f1737r;
        if (baseLayer != null) {
            KeyPath addKey = keyPath2.addKey(baseLayer.getName());
            if (keyPath.fullyResolvesTo(this.f1737r.getName(), i4)) {
                list.add(addKey.resolve(this.f1737r));
            }
            if (keyPath.propagateToChildren(getName(), i4)) {
                this.f1737r.u(keyPath, keyPath.incrementDepthBy(this.f1737r.getName(), i4) + i4, list, addKey);
            }
        }
        if (!keyPath.matches(getName(), i4)) {
            return;
        }
        if (!"__container".equals(getName())) {
            keyPath2 = keyPath2.addKey(getName());
            if (keyPath.fullyResolvesTo(getName(), i4)) {
                list.add(keyPath2.resolve(this));
            }
        }
        if (keyPath.propagateToChildren(getName(), i4)) {
            u(keyPath, i4 + keyPath.incrementDepthBy(getName(), i4), list, keyPath2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOutlineMasksAndMattes(boolean z3) {
        if (z3 && this.f1744y == null) {
            this.f1744y = new LPaint();
        }
        this.f1743x = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.f1741v.setProgress(f4);
        if (this.f1735p != null) {
            for (int i4 = 0; i4 < this.f1735p.getMaskAnimations().size(); i4++) {
                this.f1735p.getMaskAnimations().get(i4).setProgress(f4);
            }
        }
        if (this.f1734o.r() != 0.0f) {
            f4 /= this.f1734o.r();
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f1736q;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f4 / this.f1734o.r());
        }
        BaseLayer baseLayer = this.f1737r;
        if (baseLayer != null) {
            this.f1737r.setProgress(baseLayer.f1734o.r() * f4);
        }
        for (int i5 = 0; i5 < this.f1740u.size(); i5++) {
            this.f1740u.get(i5).setProgress(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(@Nullable BaseLayer baseLayer) {
        this.f1737r = baseLayer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(@Nullable BaseLayer baseLayer) {
        this.f1738s = baseLayer;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }

    void u(KeyPath keyPath, int i4, List<KeyPath> list, KeyPath keyPath2) {
    }
}
