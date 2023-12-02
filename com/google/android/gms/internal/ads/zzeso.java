package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeso implements zzeqy {
    private final zzbza zza;
    private final String zzb;
    private final ScheduledExecutorService zzc;
    private final zzfwn zzd;
    private final zzawc zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeso(String str, zzawc zzawcVar, zzbza zzbzaVar, ScheduledExecutorService scheduledExecutorService, zzfwn zzfwnVar) {
        this.zzb = str;
        this.zze = zzawcVar;
        this.zza = zzbzaVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 43;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcu)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcz)).booleanValue()) {
                zzfwm zzm = zzfwc.zzm(zzfml.zza(Tasks.forResult(null)), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzesm
                    @Override // com.google.android.gms.internal.ads.zzfvj
                    public final zzfwm zza(Object obj) {
                        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                        if (appSetIdInfo == null) {
                            return zzfwc.zzh(new zzesp(null, -1));
                        }
                        return zzfwc.zzh(new zzesp(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                    }
                }, this.zzd);
                if (((Boolean) zzbcu.zza.zze()).booleanValue()) {
                    zzm = zzfwc.zzn(zzm, ((Long) zzbcu.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzfwc.zze(zzm, Exception.class, new zzfov() { // from class: com.google.android.gms.internal.ads.zzesn
                    @Override // com.google.android.gms.internal.ads.zzfov
                    public final Object apply(Object obj) {
                        return zzeso.this.zzc((Exception) obj);
                    }
                }, this.zzd);
            }
        }
        return zzfwc.zzh(new zzesp(null, -1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzesp zzc(Exception exc) {
        this.zza.zzu(exc, "AppSetIdInfoGmscoreSignal");
        return new zzesp(null, -1);
    }
}
