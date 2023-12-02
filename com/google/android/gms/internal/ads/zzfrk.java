package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfrk extends AbstractCollection {
    final /* synthetic */ zzfrl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfrk(zzfrl zzfrlVar) {
        this.zza = zzfrlVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzfrl zzfrlVar = this.zza;
        Map zzj = zzfrlVar.zzj();
        if (zzj != null) {
            return zzj.values().iterator();
        }
        return new zzfre(zzfrlVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}
