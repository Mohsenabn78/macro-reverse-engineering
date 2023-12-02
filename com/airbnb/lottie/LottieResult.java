package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class LottieResult<V> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final V f1372a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f1373b;

    public LottieResult(V v3) {
        this.f1372a = v3;
        this.f1373b = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        if (getValue() != null && getValue().equals(lottieResult.getValue())) {
            return true;
        }
        if (getException() == null || lottieResult.getException() == null) {
            return false;
        }
        return getException().toString().equals(getException().toString());
    }

    @Nullable
    public Throwable getException() {
        return this.f1373b;
    }

    @Nullable
    public V getValue() {
        return this.f1372a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), getException()});
    }

    public LottieResult(Throwable th) {
        this.f1373b = th;
        this.f1372a = null;
    }
}
