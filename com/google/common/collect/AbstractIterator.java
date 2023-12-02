package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: a  reason: collision with root package name */
    private State f26621a = State.NOT_READY;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private T f26622b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.collect.AbstractIterator$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26623a;

        static {
            int[] iArr = new int[State.values().length];
            f26623a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26623a[State.READY.ordinal()] = 2;
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
        this.f26621a = State.FAILED;
        this.f26622b = a();
        if (this.f26621a != State.DONE) {
            this.f26621a = State.READY;
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
        this.f26621a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z3;
        if (this.f26621a != State.FAILED) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        int i4 = AnonymousClass1.f26623a[this.f26621a.ordinal()];
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
    @CanIgnoreReturnValue
    public final T next() {
        if (hasNext()) {
            this.f26621a = State.NOT_READY;
            T t3 = (T) NullnessCasts.a(this.f26622b);
            this.f26622b = null;
            return t3;
        }
        throw new NoSuchElementException();
    }

    @ParametricNullness
    public final T peek() {
        if (hasNext()) {
            return (T) NullnessCasts.a(this.f26622b);
        }
        throw new NoSuchElementException();
    }
}
