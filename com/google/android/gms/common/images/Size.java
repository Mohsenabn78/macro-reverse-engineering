package com.google.android.gms.common.images;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class Size {

    /* renamed from: a  reason: collision with root package name */
    private final int f20401a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20402b;

    public Size(int i4, int i5) {
        this.f20401a = i4;
        this.f20402b = i5;
    }

    private static NumberFormatException a(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    @NonNull
    public static Size parseSize(@NonNull String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw a(str);
                }
            }
            throw a(str);
        }
        throw new IllegalArgumentException("string must not be null");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.f20401a == size.f20401a && this.f20402b == size.f20402b) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.f20402b;
    }

    public int getWidth() {
        return this.f20401a;
    }

    public int hashCode() {
        int i4 = this.f20402b;
        int i5 = this.f20401a;
        return i4 ^ ((i5 >>> 16) | (i5 << 16));
    }

    @NonNull
    public String toString() {
        int i4 = this.f20401a;
        int i5 = this.f20402b;
        return i4 + "x" + i5;
    }
}
