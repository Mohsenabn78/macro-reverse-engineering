package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfqh implements Iterator {
    final Iterator zza;
    @CheckForNull
    Collection zzb;
    final /* synthetic */ zzfqi zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfqh(zzfqi zzfqiVar) {
        this.zzc = zzfqiVar;
        this.zza = zzfqiVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        return this.zzc.zza(entry);
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z3;
        int i4;
        if (this.zzb != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzfph.zzi(z3, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzfqv zzfqvVar = this.zzc.zzb;
        i4 = zzfqvVar.zzb;
        zzfqvVar.zzb = i4 - this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
