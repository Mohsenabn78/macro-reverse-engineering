package com.google.firebase.functions.dagger.internal;

import com.google.firebase.functions.dagger.Lazy;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f31402c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Provider<T> f31403a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f31404b = f31402c;

    private DoubleCheck(Provider<T> provider) {
        this.f31403a = provider;
    }

    private static Object a(Object obj, Object obj2) {
        boolean z3;
        if (obj != f31402c) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 && obj != obj2) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
        }
        return obj2;
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

    @Override // javax.inject.Provider
    public T get() {
        T t3 = (T) this.f31404b;
        Object obj = f31402c;
        if (t3 == obj) {
            synchronized (this) {
                t3 = this.f31404b;
                if (t3 == obj) {
                    t3 = this.f31403a.get();
                    this.f31404b = a(this.f31404b, t3);
                    this.f31403a = null;
                }
            }
        }
        return t3;
    }
}
