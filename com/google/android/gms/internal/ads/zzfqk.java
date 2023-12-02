package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfqk implements Iterator {
    @CheckForNull
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzfql zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfqk(zzfql zzfqlVar, Iterator it) {
        this.zzc = zzfqlVar;
        this.zzb = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z3;
        int i4;
        if (this.zza != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzfph.zzi(z3, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzfqv zzfqvVar = this.zzc.zza;
        i4 = zzfqvVar.zzb;
        zzfqvVar.zzb = i4 - collection.size();
        collection.clear();
        this.zza = null;
    }
}
