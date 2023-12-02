package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Queue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    @Override // java.util.Queue
    @ParametricNullness
    public E element() {
        return f().element();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection
    /* renamed from: n */
    public abstract Queue<E> f();

    @CanIgnoreReturnValue
    public boolean offer(@ParametricNullness E e4) {
        return f().offer(e4);
    }

    @Override // java.util.Queue
    @CheckForNull
    public E peek() {
        return f().peek();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    @CheckForNull
    public E poll() {
        return f().poll();
    }

    @Override // java.util.Queue
    @ParametricNullness
    @CanIgnoreReturnValue
    public E remove() {
        return f().remove();
    }
}
