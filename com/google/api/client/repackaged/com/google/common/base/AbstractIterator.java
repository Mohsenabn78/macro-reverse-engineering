package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible
/* loaded from: classes5.dex */
abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    private State f25914a = State.NOT_READY;

    /* renamed from: b  reason: collision with root package name */
    private T f25915b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.api.client.repackaged.com.google.common.base.AbstractIterator$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25916a;

        static {
            int[] iArr = new int[State.values().length];
            f25916a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25916a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean c() {
        this.f25914a = State.FAILED;
        this.f25915b = a();
        if (this.f25914a != State.DONE) {
            this.f25914a = State.READY;
            return true;
        }
        return false;
    }

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final T b() {
        this.f25914a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z3;
        if (this.f25914a != State.FAILED) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        int i4 = AnonymousClass1.f25916a[this.f25914a.ordinal()];
        if (i4 == 1) {
            return false;
        }
        if (i4 == 2) {
            return true;
        }
        return c();
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f25914a = State.NOT_READY;
            T t3 = this.f25915b;
            this.f25915b = null;
            return t3;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
