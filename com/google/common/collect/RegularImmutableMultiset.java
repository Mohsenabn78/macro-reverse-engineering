package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {

    /* renamed from: g  reason: collision with root package name */
    static final RegularImmutableMultiset<Object> f27356g = new RegularImmutableMultiset<>(ObjectCountHashMap.b());

    /* renamed from: d  reason: collision with root package name */
    final transient ObjectCountHashMap<E> f27357d;

    /* renamed from: e  reason: collision with root package name */
    private final transient int f27358e;
    @CheckForNull
    @LazyInit

    /* renamed from: f  reason: collision with root package name */
    private transient ImmutableSet<E> f27359f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class ElementSet extends IndexedImmutableSet<E> {
        private ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean f() {
            return true;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        E get(int i4) {
            return RegularImmutableMultiset.this.f27357d.i(i4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.f27357d.C();
        }
    }

    @GwtIncompatible
    /* loaded from: classes5.dex */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        SerializedForm(Multiset<? extends Object> multiset) {
            int size = multiset.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i4 = 0;
            for (Multiset.Entry<? extends Object> entry : multiset.entrySet()) {
                this.elements[i4] = entry.getElement();
                this.counts[i4] = entry.getCount();
                i4++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            ImmutableMultiset.Builder builder = new ImmutableMultiset.Builder(this.elements.length);
            int i4 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i4 < objArr.length) {
                    builder.addCopies(objArr[i4], this.counts[i4]);
                    i4++;
                } else {
                    return builder.build();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableMultiset(ObjectCountHashMap<E> objectCountHashMap) {
        this.f27357d = objectCountHashMap;
        long j4 = 0;
        for (int i4 = 0; i4 < objectCountHashMap.C(); i4++) {
            j4 += objectCountHashMap.k(i4);
        }
        this.f27358e = Ints.saturatedCast(j4);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        return this.f27357d.f(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean f() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry<E> j(int i4) {
        return this.f27357d.g(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.f27358e;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.f27359f;
        if (immutableSet == null) {
            ElementSet elementSet = new ElementSet();
            this.f27359f = elementSet;
            return elementSet;
        }
        return immutableSet;
    }
}
