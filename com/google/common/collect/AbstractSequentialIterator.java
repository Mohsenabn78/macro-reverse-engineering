package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    private T f26684a;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractSequentialIterator(@CheckForNull T t3) {
        this.f26684a = t3;
    }

    @CheckForNull
    protected abstract T a(T t3);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f26684a != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        T t3 = this.f26684a;
        if (t3 != null) {
            this.f26684a = a(t3);
            return t3;
        }
        throw new NoSuchElementException();
    }
}
