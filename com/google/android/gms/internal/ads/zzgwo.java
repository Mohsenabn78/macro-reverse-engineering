package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgwo {
    private final List zza;
    private final List zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgwo(int i4, int i5, zzgwn zzgwnVar) {
        this.zza = zzgwb.zzc(i4);
        this.zzb = zzgwb.zzc(i5);
    }

    public final zzgwo zza(zzgwr zzgwrVar) {
        this.zzb.add(zzgwrVar);
        return this;
    }

    public final zzgwo zzb(zzgwr zzgwrVar) {
        this.zza.add(zzgwrVar);
        return this;
    }

    public final zzgwp zzc() {
        return new zzgwp(this.zza, this.zzb, null);
    }
}
