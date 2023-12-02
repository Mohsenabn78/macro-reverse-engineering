package com.google.android.gms.internal.icing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzfi extends AbstractList<String> implements RandomAccess, zzdo {
    private final zzdo zza;

    public zzfi(zzdo zzdoVar) {
        this.zza = zzdoVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        return ((zzdn) this.zza).get(i4);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzfh(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i4) {
        return new zzfg(this, i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.icing.zzdo
    public final void zzf(zzcf zzcfVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.icing.zzdo
    public final Object zzg(int i4) {
        return this.zza.zzg(i4);
    }

    @Override // com.google.android.gms.internal.icing.zzdo
    public final List<?> zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.icing.zzdo
    public final zzdo zzi() {
        return this;
    }
}
