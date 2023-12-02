package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzell implements zzeqy {
    private final zzfwn zza;
    private final zzdnv zzb;
    private final zzdsc zzc;
    private final zzeln zzd;

    public zzell(zzfwn zzfwnVar, zzdnv zzdnvVar, zzdsc zzdscVar, zzeln zzelnVar) {
        this.zza = zzfwnVar;
        this.zzb = zzdnvVar;
        this.zzc = zzdscVar;
        this.zzd = zzelnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        zzbbe zzbbeVar = zzbbm.zzka;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbeVar)).booleanValue() && this.zzd.zza() != null) {
            zzelm zza = this.zzd.zza();
            zza.getClass();
            return zzfwc.zzh(zza);
        }
        if (!zzfpw.zzd((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbn)) && (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbeVar)).booleanValue() || (!this.zzd.zzd() && this.zzc.zzt()))) {
            this.zzd.zzc(true);
            return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzelk
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzell.this.zzc();
                }
            });
        }
        return zzfwc.zzh(new zzelm(new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzelm zzc() throws Exception {
        List<String> asList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbn)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : asList) {
            try {
                zzfbd zzc = this.zzb.zzc(str, new JSONObject());
                zzc.zzC();
                boolean zzt = this.zzc.zzt();
                Bundle bundle2 = new Bundle();
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzka)).booleanValue() || zzt) {
                    try {
                        zzbqh zzf = zzc.zzf();
                        if (zzf != null) {
                            bundle2.putString("sdk_version", zzf.toString());
                        }
                    } catch (zzfan unused) {
                    }
                }
                try {
                    zzbqh zze = zzc.zze();
                    if (zze != null) {
                        bundle2.putString("adapter_version", zze.toString());
                    }
                } catch (zzfan unused2) {
                }
                bundle.putBundle(str, bundle2);
            } catch (zzfan unused3) {
            }
        }
        zzelm zzelmVar = new zzelm(bundle);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzka)).booleanValue()) {
            this.zzd.zzb(zzelmVar);
        }
        return zzelmVar;
    }
}
