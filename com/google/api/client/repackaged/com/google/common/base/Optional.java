package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
/* loaded from: classes5.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public static <T> Optional<T> absent() {
        return Absent.a();
    }

    public static <T> Optional<T> fromNullable(@Nullable T t3) {
        if (t3 == null) {
            return absent();
        }
        return new Present(t3);
    }

    public static <T> Optional<T> of(T t3) {
        return new Present(Preconditions.checkNotNull(t3));
    }

    @Beta
    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterable<T>() { // from class: com.google.api.client.repackaged.com.google.common.base.Optional.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return new AbstractIterator<T>() { // from class: com.google.api.client.repackaged.com.google.common.base.Optional.1.1

                    /* renamed from: c  reason: collision with root package name */
                    private final Iterator<? extends Optional<? extends T>> f25965c;

                    {
                        this.f25965c = (Iterator) Preconditions.checkNotNull(iterable.iterator());
                    }

                    @Override // com.google.api.client.repackaged.com.google.common.base.AbstractIterator
                    protected T a() {
                        while (this.f25965c.hasNext()) {
                            Optional<? extends T> next = this.f25965c.next();
                            if (next.isPresent()) {
                                return next.get();
                            }
                        }
                        return b();
                    }
                };
            }
        };
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@Nullable Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    @Beta
    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T t3);

    @Nullable
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);
}
