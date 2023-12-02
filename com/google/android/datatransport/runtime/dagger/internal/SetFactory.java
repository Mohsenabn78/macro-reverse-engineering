package com.google.android.datatransport.runtime.dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SetFactory<T> implements Factory<Set<T>> {

    /* renamed from: c  reason: collision with root package name */
    private static final Factory<Set<Object>> f18734c = InstanceFactory.create(Collections.emptySet());

    /* renamed from: a  reason: collision with root package name */
    private final List<Provider<T>> f18735a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Provider<Collection<T>>> f18736b;

    /* loaded from: classes.dex */
    public static final class Builder<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<Provider<T>> f18737a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Provider<Collection<T>>> f18738b;

        public Builder<T> addCollectionProvider(Provider<? extends Collection<? extends T>> provider) {
            this.f18738b.add(provider);
            return this;
        }

        public Builder<T> addProvider(Provider<? extends T> provider) {
            this.f18737a.add(provider);
            return this;
        }

        public SetFactory<T> build() {
            return new SetFactory<>(this.f18737a, this.f18738b);
        }

        private Builder(int i4, int i5) {
            this.f18737a = DaggerCollections.presizedList(i4);
            this.f18738b = DaggerCollections.presizedList(i5);
        }
    }

    public static <T> Builder<T> builder(int i4, int i5) {
        return new Builder<>(i4, i5);
    }

    public static <T> Factory<Set<T>> empty() {
        return (Factory<Set<T>>) f18734c;
    }

    private SetFactory(List<Provider<T>> list, List<Provider<Collection<T>>> list2) {
        this.f18735a = list;
        this.f18736b = list2;
    }

    @Override // javax.inject.Provider
    public Set<T> get() {
        int size = this.f18735a.size();
        ArrayList arrayList = new ArrayList(this.f18736b.size());
        int size2 = this.f18736b.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Collection<T> collection = this.f18736b.get(i4).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet b4 = DaggerCollections.b(size);
        int size3 = this.f18735a.size();
        for (int i5 = 0; i5 < size3; i5++) {
            b4.add(Preconditions.checkNotNull(this.f18735a.get(i5).get()));
        }
        int size4 = arrayList.size();
        for (int i6 = 0; i6 < size4; i6++) {
            for (Object obj : (Collection) arrayList.get(i6)) {
                b4.add(Preconditions.checkNotNull(obj));
            }
        }
        return Collections.unmodifiableSet(b4);
    }
}
