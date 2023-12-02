package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgpt extends AbstractList {
    private final List zza;
    private final zzgps zzb;

    public zzgpt(List list, zzgps zzgpsVar) {
        this.zza = list;
        this.zzb = zzgpsVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i4) {
        zzaxx zzb = zzaxx.zzb(((Integer) this.zza.get(i4)).intValue());
        if (zzb == null) {
            return zzaxx.AD_FORMAT_TYPE_UNSPECIFIED;
        }
        return zzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
