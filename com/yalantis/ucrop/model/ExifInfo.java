package com.yalantis.ucrop.model;

/* loaded from: classes6.dex */
public class ExifInfo {

    /* renamed from: a  reason: collision with root package name */
    private int f38441a;

    /* renamed from: b  reason: collision with root package name */
    private int f38442b;

    /* renamed from: c  reason: collision with root package name */
    private int f38443c;

    public ExifInfo(int i4, int i5, int i6) {
        this.f38441a = i4;
        this.f38442b = i5;
        this.f38443c = i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExifInfo exifInfo = (ExifInfo) obj;
        if (this.f38441a == exifInfo.f38441a && this.f38442b == exifInfo.f38442b && this.f38443c == exifInfo.f38443c) {
            return true;
        }
        return false;
    }

    public int getExifDegrees() {
        return this.f38442b;
    }

    public int getExifOrientation() {
        return this.f38441a;
    }

    public int getExifTranslation() {
        return this.f38443c;
    }

    public int hashCode() {
        return (((this.f38441a * 31) + this.f38442b) * 31) + this.f38443c;
    }

    public void setExifDegrees(int i4) {
        this.f38442b = i4;
    }

    public void setExifOrientation(int i4) {
        this.f38441a = i4;
    }

    public void setExifTranslation(int i4) {
        this.f38443c = i4;
    }
}
