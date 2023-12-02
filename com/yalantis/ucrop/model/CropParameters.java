package com.yalantis.ucrop.model;

import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public class CropParameters {

    /* renamed from: a  reason: collision with root package name */
    private int f38434a;

    /* renamed from: b  reason: collision with root package name */
    private int f38435b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap.CompressFormat f38436c;

    /* renamed from: d  reason: collision with root package name */
    private int f38437d;

    /* renamed from: e  reason: collision with root package name */
    private String f38438e;

    /* renamed from: f  reason: collision with root package name */
    private String f38439f;

    /* renamed from: g  reason: collision with root package name */
    private ExifInfo f38440g;

    public CropParameters(int i4, int i5, Bitmap.CompressFormat compressFormat, int i6, String str, String str2, ExifInfo exifInfo) {
        this.f38434a = i4;
        this.f38435b = i5;
        this.f38436c = compressFormat;
        this.f38437d = i6;
        this.f38438e = str;
        this.f38439f = str2;
        this.f38440g = exifInfo;
    }

    public Bitmap.CompressFormat getCompressFormat() {
        return this.f38436c;
    }

    public int getCompressQuality() {
        return this.f38437d;
    }

    public ExifInfo getExifInfo() {
        return this.f38440g;
    }

    public String getImageInputPath() {
        return this.f38438e;
    }

    public String getImageOutputPath() {
        return this.f38439f;
    }

    public int getMaxResultImageSizeX() {
        return this.f38434a;
    }

    public int getMaxResultImageSizeY() {
        return this.f38435b;
    }
}
