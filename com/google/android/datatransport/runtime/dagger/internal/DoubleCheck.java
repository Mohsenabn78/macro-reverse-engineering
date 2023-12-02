package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f18723c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Provider<T> f18724a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f18725b = f18723c;

    private DoubleCheck(Provider<T> provider) {
        this.f18724a = provider;
    }

    public static <P extends Provider<T>, T> Lazy<T> lazy(P p4) {
        if (p4 instanceof Lazy) {
            return (Lazy) p4;
        }
        return new DoubleCheck((Provider) Preconditions.checkNotNull(p4));
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p4) {
        Preconditions.checkNotNull(p4);
        if (p4 instanceof DoubleCheck) {
            return p4;
        }
        return new DoubleCheck(p4);
    }

    public static Object reentrantCheck(Object obj, Object obj2) {
        boolean z3;
        if (obj != f18723c && !(obj instanceof MemoizedSentinel)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 && obj != obj2) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
        }
        return obj2;
    }

    @Override // javax.inject.Provider
    public T get() {
        T t3 = (T) this.f18725b;
        Object obj = f18723c;
        if (t3 == obj) {
            synchronized (this) {
                t3 = this.f18725b;
                if (t3 == obj) {
                    t3 = this.f18724a.get();
                    this.f18725b = reentrantCheck(this.f18725b, t3);
                    this.f18724a = null;
                }
            }
        }
        return t3;
    }
}
