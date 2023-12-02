package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class MultiClassKey {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f17582a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f17583b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f17584c;

    public MultiClassKey() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        if (this.f17582a.equals(multiClassKey.f17582a) && this.f17583b.equals(multiClassKey.f17583b) && Util.bothNullOrEqual(this.f17584c, multiClassKey.f17584c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = ((this.f17582a.hashCode() * 31) + this.f17583b.hashCode()) * 31;
        Class<?> cls = this.f17584c;
        if (cls != null) {
            i4 = cls.hashCode();
        } else {
            i4 = 0;
        }
        return hashCode + i4;
    }

    public void set(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        set(cls, cls2, null);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f17582a + ", second=" + this.f17583b + '}';
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        set(cls, cls2);
    }

    public void set(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f17582a = cls;
        this.f17583b = cls2;
        this.f17584c = cls3;
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        set(cls, cls2, cls3);
    }
}
