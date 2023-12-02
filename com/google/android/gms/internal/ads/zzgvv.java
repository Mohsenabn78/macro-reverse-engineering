package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgvv extends AbstractList {
    private static final zzgvw zzc = zzgvw.zzb(zzgvv.class);
    final List zza;
    final Iterator zzb;

    public zzgvv(List list, Iterator it) {
        this.zza = list;
        this.zzb = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i4) {
        if (this.zza.size() > i4) {
            return this.zza.get(i4);
        }
        if (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
            return get(i4);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzgvu(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        zzgvw zzgvwVar = zzc;
        zzgvwVar.zza("potentially expensive size() call");
        zzgvwVar.zza("blowup running");
        while (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
        }
        return this.zza.size();
    }
}
