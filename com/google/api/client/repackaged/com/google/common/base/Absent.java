package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes5.dex */
public final class Absent<T> extends Optional<T> {

    /* renamed from: a  reason: collision with root package name */
    static final Absent<Object> f25913a = new Absent<>();
    private static final long serialVersionUID = 0;

    private Absent() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Optional<T> a() {
        return f25913a;
    }

    private Object readResolve() {
        return f25913a;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public int hashCode() {
        return 1502476572;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public T or(T t3) {
        return (T) Preconditions.checkNotNull(t3, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    @Nullable
    public T orNull() {
        return null;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public <V> Optional<V> transform(Function<? super T, V> function) {
        Preconditions.checkNotNull(function);
        return Optional.absent();
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        return (Optional) Preconditions.checkNotNull(optional);
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public T or(Supplier<? extends T> supplier) {
        return (T) Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
