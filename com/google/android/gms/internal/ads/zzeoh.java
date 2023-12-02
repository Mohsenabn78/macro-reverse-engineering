package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeoh implements zzeqy {
    private final zzfwn zza;
    private final zzdsx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeoh(zzfwn zzfwnVar, zzdsx zzdsxVar) {
        this.zza = zzfwnVar;
        this.zzb = zzdsxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 23;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeog
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeoh.this.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzeoi zzc() throws Exception {
        return new zzeoi(this.zzb.zzc(), this.zzb.zzp(), com.google.android.gms.ads.internal.zzt.zzs().zzl(), this.zzb.zzn());
    }
}
