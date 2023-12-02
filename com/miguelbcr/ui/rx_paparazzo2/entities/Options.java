package com.miguelbcr.ui.rx_paparazzo2.entities;

import androidx.annotation.IntRange;
import com.yalantis.ucrop.UCrop;

/* loaded from: classes6.dex */
public class Options extends UCrop.Options {

    /* renamed from: b  reason: collision with root package name */
    private boolean f36181b;

    /* renamed from: c  reason: collision with root package name */
    private float f36182c;

    /* renamed from: d  reason: collision with root package name */
    private float f36183d;

    /* renamed from: e  reason: collision with root package name */
    private int f36184e;

    /* renamed from: f  reason: collision with root package name */
    private int f36185f;

    public int getHeight() {
        return this.f36185f;
    }

    public int getWidth() {
        return this.f36184e;
    }

    public float getX() {
        return this.f36182c;
    }

    public float getY() {
        return this.f36183d;
    }

    public boolean isUseSourceImageAspectRatio() {
        return this.f36181b;
    }

    public void setAspectRatio(float f4, float f5) {
        this.f36182c = f4;
        this.f36183d = f5;
    }

    public void setMaxResultSize(@IntRange(from = 100) int i4, @IntRange(from = 100) int i5) {
        this.f36184e = i4;
        this.f36185f = i5;
    }

    @Override // com.yalantis.ucrop.UCrop.Options
    public void useSourceImageAspectRatio() {
        this.f36181b = true;
    }
}
