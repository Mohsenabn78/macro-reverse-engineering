package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public class RepeaterContent implements DrawingContent, b, a, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f1497a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f1498b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f1499c;

    /* renamed from: d  reason: collision with root package name */
    private final BaseLayer f1500d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1501e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1502f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f1503g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f1504h;

    /* renamed from: i  reason: collision with root package name */
    private final TransformKeyframeAnimation f1505i;

    /* renamed from: j  reason: collision with root package name */
    private ContentGroup f1506j;

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        this.f1499c = lottieDrawable;
        this.f1500d = baseLayer;
        this.f1501e = repeater.getName();
        this.f1502f = repeater.isHidden();
        BaseKeyframeAnimation<Float, Float> createAnimation = repeater.getCopies().createAnimation();
        this.f1503g = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
        BaseKeyframeAnimation<Float, Float> createAnimation2 = repeater.getOffset().createAnimation();
        this.f1504h = createAnimation2;
        baseLayer.addAnimation(createAnimation2);
        createAnimation2.addUpdateListener(this);
        TransformKeyframeAnimation createAnimation3 = repeater.getTransform().createAnimation();
        this.f1505i = createAnimation3;
        createAnimation3.addAnimationsToLayer(baseLayer);
        createAnimation3.addListener(this);
    }

    @Override // com.airbnb.lottie.animation.content.a
    public void absorbContent(ListIterator<Content> listIterator) {
        if (this.f1506j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f1506j = new ContentGroup(this.f1499c, this.f1500d, "Repeater", this.f1502f, arrayList, null);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (this.f1505i.applyValueCallback(t3, lottieValueCallback)) {
            return;
        }
        if (t3 == LottieProperty.REPEATER_COPIES) {
            this.f1503g.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.REPEATER_OFFSET) {
            this.f1504h.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i4) {
        float floatValue = this.f1503g.getValue().floatValue();
        float floatValue2 = this.f1504h.getValue().floatValue();
        float floatValue3 = this.f1505i.getStartOpacity().getValue().floatValue() / 100.0f;
        float floatValue4 = this.f1505i.getEndOpacity().getValue().floatValue() / 100.0f;
        for (int i5 = ((int) floatValue) - 1; i5 >= 0; i5--) {
            this.f1497a.set(matrix);
            float f4 = i5;
            this.f1497a.preConcat(this.f1505i.getMatrixForRepeater(f4 + floatValue2));
            this.f1506j.draw(canvas, this.f1497a, (int) (i4 * MiscUtils.lerp(floatValue3, floatValue4, f4 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z3) {
        this.f1506j.getBounds(rectF, matrix, z3);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1501e;
    }

    @Override // com.airbnb.lottie.animation.content.b
    public Path getPath() {
        Path path = this.f1506j.getPath();
        this.f1498b.reset();
        float floatValue = this.f1503g.getValue().floatValue();
        float floatValue2 = this.f1504h.getValue().floatValue();
        for (int i4 = ((int) floatValue) - 1; i4 >= 0; i4--) {
            this.f1497a.set(this.f1505i.getMatrixForRepeater(i4 + floatValue2));
            this.f1498b.addPath(path, this.f1497a);
        }
        return this.f1498b;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.f1499c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i4, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i4, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        this.f1506j.setContents(list, list2);
    }
}
