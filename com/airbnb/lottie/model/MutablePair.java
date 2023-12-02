package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class MutablePair<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    T f1607a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    T f1608b;

    private static boolean a(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!a(pair.first, this.f1607a) || !a(pair.second, this.f1608b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        T t3 = this.f1607a;
        int i4 = 0;
        if (t3 == null) {
            hashCode = 0;
        } else {
            hashCode = t3.hashCode();
        }
        T t4 = this.f1608b;
        if (t4 != null) {
            i4 = t4.hashCode();
        }
        return hashCode ^ i4;
    }

    public void set(T t3, T t4) {
        this.f1607a = t3;
        this.f1608b = t4;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f1607a) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + String.valueOf(this.f1608b) + "}";
    }
}
