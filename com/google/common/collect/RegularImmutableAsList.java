package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int a(Object[] objArr, int i4) {
        return this.delegateList.a(objArr, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    @CheckForNull
    public Object[] b() {
        return this.delegateList.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int c() {
        return this.delegateList.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int e() {
        return this.delegateList.e();
    }

    @Override // java.util.List
    public E get(int i4) {
        return this.delegateList.get(i4);
    }

    @Override // com.google.common.collect.ImmutableAsList
    ImmutableCollection<E> l() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<E> listIterator(int i4) {
        return (UnmodifiableListIterator<? extends E>) this.delegateList.listIterator(i4);
    }
}
