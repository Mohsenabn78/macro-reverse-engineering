package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ContentGroup implements DrawingContent, b, BaseKeyframeAnimation.AnimationListener, KeyPathElement {

    /* renamed from: a  reason: collision with root package name */
    private Paint f1407a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f1408b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f1409c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f1410d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f1411e;

    /* renamed from: f  reason: collision with root package name */
    private final String f1412f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f1413g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Content> f1414h;

    /* renamed from: i  reason: collision with root package name */
    private final LottieDrawable f1415i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private List<b> f1416j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private TransformKeyframeAnimation f1417k;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        this(lottieDrawable, baseLayer, shapeGroup.getName(), shapeGroup.isHidden(), a(lottieDrawable, baseLayer, shapeGroup.getItems()), b(shapeGroup.getItems()));
    }

    private static List<Content> a(LottieDrawable lottieDrawable, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            Content content = list.get(i4).toContent(lottieDrawable, baseLayer);
            if (content != null) {
                arrayList.add(content);
            }
        }
        return arrayList;
    }

    @Nullable
    static AnimatableTransform b(List<ContentModel> list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            ContentModel contentModel = list.get(i4);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    private boolean e() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.f1414h.size(); i5++) {
            if ((this.f1414h.get(i5) instanceof DrawingContent) && (i4 = i4 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f1417k;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.applyValueCallback(t3, lottieValueCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b> c() {
        if (this.f1416j == null) {
            this.f1416j = new ArrayList();
            for (int i4 = 0; i4 < this.f1414h.size(); i4++) {
                Content content = this.f1414h.get(i4);
                if (content instanceof b) {
                    this.f1416j.add((b) content);
                }
            }
        }
        return this.f1416j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix d() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f1417k;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.getMatrix();
        }
        this.f1409c.reset();
        return this.f1409c;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i4) {
        boolean z3;
        int intValue;
        if (this.f1413g) {
            return;
        }
        this.f1409c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f1417k;
        if (transformKeyframeAnimation != null) {
            this.f1409c.preConcat(transformKeyframeAnimation.getMatrix());
            if (this.f1417k.getOpacity() == null) {
                intValue = 100;
            } else {
                intValue = this.f1417k.getOpacity().getValue().intValue();
            }
            i4 = (int) ((((intValue / 100.0f) * i4) / 255.0f) * 255.0f);
        }
        if (this.f1415i.isApplyingOpacityToLayersEnabled() && e() && i4 != 255) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            this.f1408b.set(0.0f, 0.0f, 0.0f, 0.0f);
            getBounds(this.f1408b, this.f1409c, true);
            this.f1407a.setAlpha(i4);
            Utils.saveLayerCompat(canvas, this.f1408b, this.f1407a);
        }
        if (z3) {
            i4 = 255;
        }
        for (int size = this.f1414h.size() - 1; size >= 0; size--) {
            Content content = this.f1414h.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).draw(canvas, this.f1409c, i4);
            }
        }
        if (z3) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z3) {
        this.f1409c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f1417k;
        if (transformKeyframeAnimation != null) {
            this.f1409c.preConcat(transformKeyframeAnimation.getMatrix());
        }
        this.f1411e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f1414h.size() - 1; size >= 0; size--) {
            Content content = this.f1414h.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getBounds(this.f1411e, this.f1409c, z3);
                rectF.union(this.f1411e);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1412f;
    }

    @Override // com.airbnb.lottie.animation.content.b
    public Path getPath() {
        this.f1409c.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.f1417k;
        if (transformKeyframeAnimation != null) {
            this.f1409c.set(transformKeyframeAnimation.getMatrix());
        }
        this.f1410d.reset();
        if (this.f1413g) {
            return this.f1410d;
        }
        for (int size = this.f1414h.size() - 1; size >= 0; size--) {
            Content content = this.f1414h.get(size);
            if (content instanceof b) {
                this.f1410d.addPath(((b) content).getPath(), this.f1409c);
            }
        }
        return this.f1410d;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.f1415i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i4, List<KeyPath> list, KeyPath keyPath2) {
        if (!keyPath.matches(getName(), i4) && !"__container".equals(getName())) {
            return;
        }
        if (!"__container".equals(getName())) {
            keyPath2 = keyPath2.addKey(getName());
            if (keyPath.fullyResolvesTo(getName(), i4)) {
                list.add(keyPath2.resolve(this));
            }
        }
        if (keyPath.propagateToChildren(getName(), i4)) {
            int incrementDepthBy = i4 + keyPath.incrementDepthBy(getName(), i4);
            for (int i5 = 0; i5 < this.f1414h.size(); i5++) {
                Content content = this.f1414h.get(i5);
                if (content instanceof KeyPathElement) {
                    ((KeyPathElement) content).resolveKeyPath(keyPath, incrementDepthBy, list, keyPath2);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f1414h.size());
        arrayList.addAll(list);
        for (int size = this.f1414h.size() - 1; size >= 0; size--) {
            Content content = this.f1414h.get(size);
            content.setContents(arrayList, this.f1414h.subList(0, size));
            arrayList.add(content);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z3, List<Content> list, @Nullable AnimatableTransform animatableTransform) {
        this.f1407a = new LPaint();
        this.f1408b = new RectF();
        this.f1409c = new Matrix();
        this.f1410d = new Path();
        this.f1411e = new RectF();
        this.f1412f = str;
        this.f1415i = lottieDrawable;
        this.f1413g = z3;
        this.f1414h = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation createAnimation = animatableTransform.createAnimation();
            this.f1417k = createAnimation;
            createAnimation.addAnimationsToLayer(baseLayer);
            this.f1417k.addListener(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof a) {
                arrayList.add((a) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((a) arrayList.get(size2)).absorbContent(list.listIterator(list.size()));
        }
    }
}
