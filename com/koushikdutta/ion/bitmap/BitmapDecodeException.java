package com.koushikdutta.ion.bitmap;

/* loaded from: classes6.dex */
public class BitmapDecodeException extends Exception {
    public final int height;
    public final int width;

    public BitmapDecodeException(int i4, int i5) {
        this.width = i4;
        this.height = i5;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + " size=" + this.width + 'x' + this.height;
    }
}
