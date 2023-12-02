package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcqg implements zzgwe {
    private final zzgwr zza;

    public zzcqg(zzgwr zzgwrVar) {
        this.zza = zzgwrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    /* renamed from: zza */
    public final Boolean zzb() {
        boolean z3 = true;
        if (((zzcux) this.zza).zza().zza() == null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfn)).booleanValue()) {
                z3 = false;
            }
        }
        return Boolean.valueOf(z3);
    }
}
