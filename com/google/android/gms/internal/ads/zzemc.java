package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzemc implements zzeqy {
    @VisibleForTesting
    final zzbza zza;
    @VisibleForTesting
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzfwn zzd;
    private final Context zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzemc(Context context, zzbza zzbzaVar, ScheduledExecutorService scheduledExecutorService, zzfwn zzfwnVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcy)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzbzaVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 11;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        Task<AppSetIdInfo> appSetIdInfo;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcu)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcz)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcv)).booleanValue()) {
                    return zzfwc.zzl(zzfml.zza(this.zzb.getAppSetIdInfo()), new zzfov() { // from class: com.google.android.gms.internal.ads.zzelz
                        @Override // com.google.android.gms.internal.ads.zzfov
                        public final Object apply(Object obj) {
                            AppSetIdInfo appSetIdInfo2 = (AppSetIdInfo) obj;
                            return new zzemd(appSetIdInfo2.getId(), appSetIdInfo2.getScope());
                        }
                    }, zzcae.zzf);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcy)).booleanValue()) {
                    appSetIdInfo = zzfbl.zza(this.zze);
                } else {
                    appSetIdInfo = this.zzb.getAppSetIdInfo();
                }
                if (appSetIdInfo == null) {
                    return zzfwc.zzh(new zzemd(null, -1));
                }
                zzfwm zzm = zzfwc.zzm(zzfml.zza(appSetIdInfo), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzema
                    @Override // com.google.android.gms.internal.ads.zzfvj
                    public final zzfwm zza(Object obj) {
                        AppSetIdInfo appSetIdInfo2 = (AppSetIdInfo) obj;
                        if (appSetIdInfo2 == null) {
                            return zzfwc.zzh(new zzemd(null, -1));
                        }
                        return zzfwc.zzh(new zzemd(appSetIdInfo2.getId(), appSetIdInfo2.getScope()));
                    }
                }, zzcae.zzf);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcw)).booleanValue()) {
                    zzm = zzfwc.zzn(zzm, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcx)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzfwc.zze(zzm, Exception.class, new zzfov() { // from class: com.google.android.gms.internal.ads.zzemb
                    @Override // com.google.android.gms.internal.ads.zzfov
                    public final Object apply(Object obj) {
                        zzemc.this.zza.zzu((Exception) obj, "AppSetIdInfoSignal");
                        return new zzemd(null, -1);
                    }
                }, this.zzd);
            }
        }
        return zzfwc.zzh(new zzemd(null, -1));
    }
}
