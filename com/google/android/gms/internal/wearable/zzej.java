package com.google.android.gms.internal.wearable;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzej extends AbstractList implements RandomAccess, zzck {
    private final zzck zza;

    public zzej(zzck zzckVar) {
        this.zza = zzckVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        return ((zzcj) this.zza).get(i4);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzei(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i4) {
        return new zzeh(this, i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.wearable.zzck
    public final Object zzf(int i4) {
        return this.zza.zzf(i4);
    }

    @Override // com.google.android.gms.internal.wearable.zzck
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.wearable.zzck
    public final void zzi(zzaw zzawVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.wearable.zzck
    public final zzck zze() {
        return this;
    }
}
