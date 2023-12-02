package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {
    @CheckForNull

    /* renamed from: p  reason: collision with root package name */
    private List<Present<V>> f28461p;

    /* loaded from: classes5.dex */
    static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z3) {
            super(immutableCollection, z3);
            R();
        }

        @Override // com.google.common.util.concurrent.CollectionFuture
        /* renamed from: Y */
        public List<V> X(List<Present<V>> list) {
            V v3;
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(list.size());
            for (Present<V> present : list) {
                if (present != null) {
                    v3 = present.f28462a;
                } else {
                    v3 = null;
                }
                newArrayListWithCapacity.add(v3);
            }
            return Collections.unmodifiableList(newArrayListWithCapacity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Present<V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        final V f28462a;

        Present(@ParametricNullness V v3) {
            this.f28462a = v3;
        }
    }

    CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z3) {
        super(immutableCollection, z3, true);
        List<Present<V>> newArrayListWithCapacity;
        if (immutableCollection.isEmpty()) {
            newArrayListWithCapacity = Collections.emptyList();
        } else {
            newArrayListWithCapacity = Lists.newArrayListWithCapacity(immutableCollection.size());
        }
        for (int i4 = 0; i4 < immutableCollection.size(); i4++) {
            newArrayListWithCapacity.add(null);
        }
        this.f28461p = newArrayListWithCapacity;
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    final void M(int i4, @ParametricNullness V v3) {
        List<Present<V>> list = this.f28461p;
        if (list != null) {
            list.set(i4, new Present<>(v3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.util.concurrent.AggregateFuture
    final void P() {
        List<Present<V>> list = this.f28461p;
        if (list != null) {
            set(X(list));
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    void W(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.W(releaseResourcesReason);
        this.f28461p = null;
    }

    abstract C X(List<Present<V>> list);
}
