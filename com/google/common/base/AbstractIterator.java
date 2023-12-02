package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    private State f26262a = State.NOT_READY;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private T f26263b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.base.AbstractIterator$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26264a;

        static {
            int[] iArr = new int[State.values().length];
            f26264a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26264a[State.READY.ordinal()] = 2;
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
        this.f26262a = State.FAILED;
        this.f26263b = a();
        if (this.f26262a != State.DONE) {
            this.f26262a = State.READY;
            return true;
        }
        return false;
    }

    @CheckForNull
    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    @CheckForNull
    public final T b() {
        this.f26262a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z3;
        if (this.f26262a != State.FAILED) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        int i4 = AnonymousClass1.f26264a[this.f26262a.ordinal()];
        if (i4 == 1) {
            return false;
        }
        if (i4 == 2) {
            return true;
        }
        return c();
    }

    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        if (hasNext()) {
            this.f26262a = State.NOT_READY;
            T t3 = (T) NullnessCasts.a(this.f26263b);
            this.f26263b = null;
            return t3;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
