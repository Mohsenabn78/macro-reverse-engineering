package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcdd extends com.google.android.gms.ads.internal.util.zzb {
    final zzcca zza;
    final zzcdl zzb;
    private final String zzc;
    private final String[] zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcdd(zzcca zzccaVar, zzcdl zzcdlVar, String str, String[] strArr) {
        this.zza = zzccaVar;
        this.zzb = zzcdlVar;
        this.zzc = str;
        this.zzd = strArr;
        com.google.android.gms.ads.internal.zzt.zzy().zzb(this);
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        try {
            this.zzb.zzu(this.zzc, this.zzd);
        } finally {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcdc(this));
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final zzfwm zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbP)).booleanValue() && (this.zzb instanceof zzcdu)) {
            return zzcae.zze.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzcdb
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzcdd.this.zzd();
                }
            });
        }
        return super.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Boolean zzd() throws Exception {
        return Boolean.valueOf(this.zzb.zzw(this.zzc, this.zzd, this));
    }

    public final String zze() {
        return this.zzc;
    }
}
