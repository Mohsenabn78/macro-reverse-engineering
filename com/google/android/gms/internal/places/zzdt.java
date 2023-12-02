package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class zzdt extends AbstractList<String> implements zzbr, RandomAccess {
    private final zzbr zzmj;

    public zzdt(zzbr zzbrVar) {
        this.zzmj = zzbrVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        return (String) this.zzmj.get(i4);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzdv(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i4) {
        return new zzdw(this, i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzmj.size();
    }

    @Override // com.google.android.gms.internal.places.zzbr
    public final Object zzae(int i4) {
        return this.zzmj.zzae(i4);
    }

    @Override // com.google.android.gms.internal.places.zzbr
    public final List<?> zzby() {
        return this.zzmj.zzby();
    }

    @Override // com.google.android.gms.internal.places.zzbr
    public final zzbr zzbz() {
        return this;
    }
}
