package com.google.android.gms.internal.ads;

import android.os.Binder;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdwq {
    private final zzfwn zza;
    private final zzfwn zzb;
    private final zzdxl zzc;
    private final zzgvy zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdwq(zzfwn zzfwnVar, zzfwn zzfwnVar2, zzdxl zzdxlVar, zzgvy zzgvyVar) {
        this.zza = zzfwnVar;
        this.zzb = zzfwnVar2;
        this.zzc = zzdxlVar;
        this.zzd = zzgvyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zza(zzbtm zzbtmVar) throws Exception {
        return this.zzc.zza(zzbtmVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjV)).longValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(zzbtm zzbtmVar, int i4, zzdwa zzdwaVar) throws Exception {
        return ((zzdyr) this.zzd.zzb()).zzb(zzbtmVar, i4);
    }

    public final zzfwm zzc(final zzbtm zzbtmVar) {
        zzfwm zzf;
        String str = zzbtmVar.zzf;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzs.zzy(str)) {
            zzf = zzfwc.zzg(new zzdwa(1, "Ads service proxy force local"));
        } else {
            zzf = zzfwc.zzf(zzfwc.zzk(new zzfvi() { // from class: com.google.android.gms.internal.ads.zzdwn
                @Override // com.google.android.gms.internal.ads.zzfvi
                public final zzfwm zza() {
                    return zzdwq.this.zza(zzbtmVar);
                }
            }, this.zza), ExecutionException.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdwo
                @Override // com.google.android.gms.internal.ads.zzfvj
                public final zzfwm zza(Object obj) {
                    Throwable th = (ExecutionException) obj;
                    if (th.getCause() != null) {
                        th = th.getCause();
                    }
                    return zzfwc.zzg(th);
                }
            }, this.zzb);
        }
        final int callingUid = Binder.getCallingUid();
        return zzfwc.zzf(zzf, zzdwa.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdwp
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzdwq.this.zzb(zzbtmVar, callingUid, (zzdwa) obj);
            }
        }, this.zzb);
    }
}
