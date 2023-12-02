package com.yalantis.ucrop.model;

import android.graphics.RectF;

/* loaded from: classes6.dex */
public class ImageState {

    /* renamed from: a  reason: collision with root package name */
    private RectF f38444a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f38445b;

    /* renamed from: c  reason: collision with root package name */
    private float f38446c;

    /* renamed from: d  reason: collision with root package name */
    private float f38447d;

    public ImageState(RectF rectF, RectF rectF2, float f4, float f5) {
        this.f38444a = rectF;
        this.f38445b = rectF2;
        this.f38446c = f4;
        this.f38447d = f5;
    }

    public RectF getCropRect() {
        return this.f38444a;
    }

    public float getCurrentAngle() {
        return this.f38447d;
    }

    public RectF getCurrentImageRect() {
        return this.f38445b;
    }

    public float getCurrentScale() {
        return this.f38446c;
    }
}
