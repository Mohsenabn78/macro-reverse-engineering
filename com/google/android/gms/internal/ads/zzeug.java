package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeug implements zzeqy {
    private final zzbza zza;
    private final boolean zzb;
    private final boolean zzc;
    private final ScheduledExecutorService zzd;
    private final zzfwn zze;
    private final String zzf;
    private final zzbyp zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeug(zzbza zzbzaVar, boolean z3, boolean z4, zzbyp zzbypVar, zzfwn zzfwnVar, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzbzaVar;
        this.zzb = z3;
        this.zzc = z4;
        this.zzg = zzbypVar;
        this.zze = zzfwnVar;
        this.zzf = str;
        this.zzd = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 50;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgV)).booleanValue() && this.zzc) {
            return zzfwc.zzh(null);
        }
        if (!this.zzb) {
            return zzfwc.zzh(null);
        }
        return zzfwc.zze(zzfwc.zzn(zzfwc.zzl(zzfwc.zzh(null), new zzfov() { // from class: com.google.android.gms.internal.ads.zzeue
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                String str = (String) obj;
                if (str == null) {
                    return null;
                }
                return new zzeuh(str);
            }
        }, this.zze), ((Long) zzbds.zzc.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd), Exception.class, new zzfov() { // from class: com.google.android.gms.internal.ads.zzeuf
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                zzeug.this.zzc((Exception) obj);
                return null;
            }
        }, this.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzeuh zzc(Exception exc) {
        this.zza.zzu(exc, "TrustlessTokenSignal");
        return null;
    }
}
