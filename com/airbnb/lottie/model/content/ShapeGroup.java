package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class ShapeGroup implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f1692a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ContentModel> f1693b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1694c;

    public ShapeGroup(String str, List<ContentModel> list, boolean z3) {
        this.f1692a = str;
        this.f1693b = list;
        this.f1694c = z3;
    }

    public List<ContentModel> getItems() {
        return this.f1693b;
    }

    public String getName() {
        return this.f1692a;
    }

    public boolean isHidden() {
        return this.f1694c;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f1692a + "' Shapes: " + Arrays.toString(this.f1693b.toArray()) + '}';
    }
}
