package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
class zzfqr implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfqs zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfqr(zzfqs zzfqsVar, Iterator it) {
        this.zzc = zzfqsVar;
        this.zzb = zzfqsVar.zzb;
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i4;
        this.zza.remove();
        zzfqv zzfqvVar = this.zzc.zze;
        i4 = zzfqvVar.zzb;
        zzfqvVar.zzb = i4 - 1;
        this.zzc.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb == this.zzb) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfqr(zzfqs zzfqsVar) {
        Iterator it;
        this.zzc = zzfqsVar;
        Collection collection = zzfqsVar.zzb;
        this.zzb = collection;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }
}
