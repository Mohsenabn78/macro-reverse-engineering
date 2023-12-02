package com.google.android.material.color;

import androidx.annotation.ColorInt;

/* loaded from: classes5.dex */
public final class ColorRoles {

    /* renamed from: a  reason: collision with root package name */
    private final int f23380a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23381b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23382c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23383d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorRoles(@ColorInt int i4, @ColorInt int i5, @ColorInt int i6, @ColorInt int i7) {
        this.f23380a = i4;
        this.f23381b = i5;
        this.f23382c = i6;
        this.f23383d = i7;
    }

    @ColorInt
    public int getAccent() {
        return this.f23380a;
    }

    @ColorInt
    public int getAccentContainer() {
        return this.f23382c;
    }

    @ColorInt
    public int getOnAccent() {
        return this.f23381b;
    }

    @ColorInt
    public int getOnAccentContainer() {
        return this.f23383d;
    }
}
