package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: classes2.dex */
public class LottieImageAsset {

    /* renamed from: a  reason: collision with root package name */
    private final int f1366a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1367b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1368c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1369d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1370e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f1371f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieImageAsset(int i4, int i5, String str, String str2, String str3) {
        this.f1366a = i4;
        this.f1367b = i5;
        this.f1368c = str;
        this.f1369d = str2;
        this.f1370e = str3;
    }

    @Nullable
    public Bitmap getBitmap() {
        return this.f1371f;
    }

    public String getDirName() {
        return this.f1370e;
    }

    public String getFileName() {
        return this.f1369d;
    }

    public int getHeight() {
        return this.f1367b;
    }

    public String getId() {
        return this.f1368c;
    }

    public int getWidth() {
        return this.f1366a;
    }

    public boolean hasBitmap() {
        if (this.f1371f == null && (!this.f1369d.startsWith("data:") || this.f1369d.indexOf("base64,") <= 0)) {
            return false;
        }
        return true;
    }

    public void setBitmap(@Nullable Bitmap bitmap) {
        this.f1371f = bitmap;
    }
}
