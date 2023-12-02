package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzfqj implements Iterator {
    final Iterator zza;
    @CheckForNull
    Object zzb;
    @CheckForNull
    Collection zzc;
    Iterator zzd;
    final /* synthetic */ zzfqv zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfqj(zzfqv zzfqvVar) {
        Map map;
        this.zze = zzfqvVar;
        map = zzfqvVar.zza;
        this.zza = map.entrySet().iterator();
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzfsl.INSTANCE;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.zza.hasNext() && !this.zzd.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.zzd.hasNext()) {
            Map.Entry entry = (Map.Entry) this.zza.next();
            this.zzb = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.zzc = collection;
            this.zzd = collection.iterator();
        }
        return this.zzd.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i4;
        this.zzd.remove();
        Collection collection = this.zzc;
        collection.getClass();
        if (collection.isEmpty()) {
            this.zza.remove();
        }
        zzfqv zzfqvVar = this.zze;
        i4 = zzfqvVar.zzb;
        zzfqvVar.zzb = i4 - 1;
    }
}
