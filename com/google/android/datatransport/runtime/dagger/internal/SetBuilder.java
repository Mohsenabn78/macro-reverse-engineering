package com.google.android.datatransport.runtime.dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class SetBuilder<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<T> f18733a;

    private SetBuilder(int i4) {
        this.f18733a = new ArrayList(i4);
    }

    public static <T> SetBuilder<T> newSetBuilder(int i4) {
        return new SetBuilder<>(i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SetBuilder<T> add(T t3) {
        this.f18733a.add(Preconditions.checkNotNull(t3, "Set contributions cannot be null"));
        return this;
    }

    public SetBuilder<T> addAll(Collection<? extends T> collection) {
        for (T t3 : collection) {
            Preconditions.checkNotNull(t3, "Set contributions cannot be null");
        }
        this.f18733a.addAll(collection);
        return this;
    }

    public Set<T> build() {
        int size = this.f18733a.size();
        if (size != 0) {
            if (size != 1) {
                return Collections.unmodifiableSet(new HashSet(this.f18733a));
            }
            return Collections.singleton(this.f18733a.get(0));
        }
        return Collections.emptySet();
    }
}
