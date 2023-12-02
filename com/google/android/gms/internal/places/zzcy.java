package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
final class zzcy<E> extends zzq<E> {
    private static final zzcy<Object> zzlo;
    private final List<E> zzka;

    static {
        zzcy<Object> zzcyVar = new zzcy<>(new ArrayList(0));
        zzlo = zzcyVar;
        zzcyVar.zzab();
    }

    zzcy() {
        this(new ArrayList(10));
    }

    public static <E> zzcy<E> zzct() {
        return (zzcy<E>) zzlo;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final void add(int i4, E e4) {
        zzac();
        this.zzka.add(i4, e4);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i4) {
        return this.zzka.get(i4);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final E remove(int i4) {
        zzac();
        E remove = this.zzka.remove(i4);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final E set(int i4, E e4) {
        zzac();
        E e5 = this.zzka.set(i4, e4);
        ((AbstractList) this).modCount++;
        return e5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzka.size();
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh zzh(int i4) {
        if (i4 >= size()) {
            ArrayList arrayList = new ArrayList(i4);
            arrayList.addAll(this.zzka);
            return new zzcy(arrayList);
        }
        throw new IllegalArgumentException();
    }

    private zzcy(List<E> list) {
        this.zzka = list;
    }
}
