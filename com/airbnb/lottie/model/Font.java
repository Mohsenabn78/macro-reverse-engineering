package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class Font {

    /* renamed from: a  reason: collision with root package name */
    private final String f1591a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1592b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1593c;

    /* renamed from: d  reason: collision with root package name */
    private final float f1594d;

    public Font(String str, String str2, String str3, float f4) {
        this.f1591a = str;
        this.f1592b = str2;
        this.f1593c = str3;
        this.f1594d = f4;
    }

    public String getFamily() {
        return this.f1591a;
    }

    public String getName() {
        return this.f1592b;
    }

    public String getStyle() {
        return this.f1593c;
    }
}
