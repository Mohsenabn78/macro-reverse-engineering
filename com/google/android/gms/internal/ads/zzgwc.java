package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgwc implements zzgwe {
    private zzgwr zza;

    public static void zza(zzgwr zzgwrVar, zzgwr zzgwrVar2) {
        zzgwc zzgwcVar = (zzgwc) zzgwrVar;
        if (zzgwcVar.zza == null) {
            zzgwcVar.zza = zzgwrVar2;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final Object zzb() {
        zzgwr zzgwrVar = this.zza;
        if (zzgwrVar != null) {
            return zzgwrVar.zzb();
        }
        throw new IllegalStateException();
    }
}
