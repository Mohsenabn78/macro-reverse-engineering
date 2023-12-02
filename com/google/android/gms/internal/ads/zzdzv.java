package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdzv implements zzcwu, zzcvj {
    private static final Object zza = new Object();
    private static int zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private final zzeaf zzd;

    public zzdzv(zzeaf zzeafVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzd = zzeafVar;
        this.zzc = zzgVar;
    }

    private final void zzb(boolean z3) {
        int i4;
        int intValue;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfW)).booleanValue() && !this.zzc.zzP()) {
            Object obj = zza;
            synchronized (obj) {
                i4 = zzb;
                intValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfX)).intValue();
            }
            if (i4 >= intValue) {
                return;
            }
            this.zzd.zzd(z3);
            synchronized (obj) {
                zzb++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvj
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzn() {
        zzb(true);
    }
}
