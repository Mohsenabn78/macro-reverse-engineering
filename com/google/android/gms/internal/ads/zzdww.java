package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdww {
    private final zzfwn zza;
    private final zzfwn zzb;
    private final zzdxo zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdww(zzfwn zzfwnVar, zzfwn zzfwnVar2, zzdxo zzdxoVar) {
        this.zza = zzfwnVar;
        this.zzb = zzfwnVar2;
        this.zzc = zzdxoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zza(zzbti zzbtiVar) throws Exception {
        return this.zzc.zza(zzbtiVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjU)).longValue());
    }

    public final zzfwm zzb(final zzbti zzbtiVar) {
        zzfwm zzf;
        String str = zzbtiVar.zzb;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzs.zzy(str)) {
            zzf = zzfwc.zzg(new zzdwa(1, "Ads signal service force local"));
        } else {
            zzf = zzfwc.zzf(zzfwc.zzk(new zzfvi() { // from class: com.google.android.gms.internal.ads.zzdws
                @Override // com.google.android.gms.internal.ads.zzfvi
                public final zzfwm zza() {
                    return zzdww.this.zza(zzbtiVar);
                }
            }, this.zza), ExecutionException.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdwt
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
        return zzfwc.zzm(zzfwc.zzf(zzfvt.zzv(zzf), zzdwa.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdwu
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                zzdwa zzdwaVar = (zzdwa) obj;
                return zzfwc.zzh(null);
            }
        }, this.zzb), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdwv
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                InputStream inputStream = (InputStream) obj;
                JSONObject jSONObject = new JSONObject();
                if (inputStream == null) {
                    return zzfwc.zzh(jSONObject);
                }
                try {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    jSONObject = new JSONObject(com.google.android.gms.ads.internal.util.zzs.zzJ(new InputStreamReader(inputStream)));
                } catch (IOException | JSONException e4) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "AdsServiceSignalTask.startAdsServiceSignalTask");
                }
                return zzfwc.zzh(jSONObject);
            }
        }, this.zzb);
    }
}
