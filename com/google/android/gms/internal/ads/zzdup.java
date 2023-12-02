package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdup implements zzgwe {
    private final zzgwr zza;

    public zzdup(zzgwr zzgwrVar) {
        this.zza = zzgwrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    /* renamed from: zza */
    public final String zzb() {
        String packageName = ((zzcha) this.zza).zza().getPackageName();
        zzgwm.zzb(packageName);
        return packageName;
    }
}
