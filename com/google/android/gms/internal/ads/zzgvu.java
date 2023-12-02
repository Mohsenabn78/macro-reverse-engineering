package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgvu implements Iterator {
    int zza = 0;
    final /* synthetic */ zzgvv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgvu(zzgvv zzgvvVar) {
        this.zzb = zzgvvVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zza >= this.zzb.zza.size() && !this.zzb.zzb.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.zza < this.zzb.zza.size()) {
            List list = this.zzb.zza;
            int i4 = this.zza;
            this.zza = i4 + 1;
            return list.get(i4);
        }
        zzgvv zzgvvVar = this.zzb;
        zzgvvVar.zza.add(zzgvvVar.zzb.next());
        return next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
