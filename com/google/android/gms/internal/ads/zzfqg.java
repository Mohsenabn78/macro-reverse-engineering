package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfqg extends zzfst {
    final /* synthetic */ zzfqi zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfqg(zzfqi zzfqiVar) {
        this.zza = zzfqiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfst, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        return zzfrb.zza(this.zza.zza.entrySet(), obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzfqh(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfst, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        entry.getClass();
        zzfqv.zzo(this.zza.zzb, entry.getKey());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzfst
    final Map zza() {
        return this.zza;
    }
}
