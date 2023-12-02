package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzedh implements zzeci {
    private final Context zza;
    private final zzcpy zzb;
    private final Executor zzc;

    public zzedh(Context context, zzcpy zzcpyVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcpyVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezzVar, final zzezn zzeznVar, zzecf zzecfVar) throws zzfan, zzefu {
        final View zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() && zzeznVar.zzah) {
            zzbof zzc = ((zzfbd) zzecfVar.zzb).zzc();
            if (zzc != null) {
                try {
                    zza = (View) ObjectWrapper.unwrap(zzc.zze());
                    boolean zzf = zzc.zzf();
                    if (zza != null) {
                        if (zzf) {
                            try {
                                zza = (View) zzfwc.zzm(zzfwc.zzh(null), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzedg
                                    @Override // com.google.android.gms.internal.ads.zzfvj
                                    public final zzfwm zza(Object obj) {
                                        return zzedh.this.zzc(zza, zzeznVar, obj);
                                    }
                                }, zzcae.zze).get();
                            } catch (InterruptedException | ExecutionException e4) {
                                throw new zzfan(e4);
                            }
                        }
                    } else {
                        throw new zzfan(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
                    }
                } catch (RemoteException e5) {
                    throw new zzfan(e5);
                }
            } else {
                zzbzr.zzg("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
                throw new zzfan(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
            }
        } else {
            zza = ((zzfbd) zzecfVar.zzb).zza();
        }
        zzcpy zzcpyVar = this.zzb;
        zzcrs zzcrsVar = new zzcrs(zzezzVar, zzeznVar, zzecfVar.zza);
        final zzfbd zzfbdVar = (zzfbd) zzecfVar.zzb;
        zzcpc zza2 = zzcpyVar.zza(zzcrsVar, new zzcpi(zza, null, new zzcrb() { // from class: com.google.android.gms.internal.ads.zzedf
            @Override // com.google.android.gms.internal.ads.zzcrb
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return zzfbd.this.zzb();
            }
        }, (zzezo) zzeznVar.zzv.get(0)));
        zza2.zzg().zza(zza);
        zza2.zzd().zzm(new zzcnd((zzfbd) zzecfVar.zzb), this.zzc);
        ((zzedy) zzecfVar.zzc).zzc(zza2.zzj());
        return zza2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final void zzb(zzezz zzezzVar, zzezn zzeznVar, zzecf zzecfVar) throws zzfan {
        com.google.android.gms.ads.internal.client.zzq zza;
        com.google.android.gms.ads.internal.client.zzq zzqVar = zzezzVar.zza.zza.zze;
        if (zzqVar.zzn) {
            zza = new com.google.android.gms.ads.internal.client.zzq(this.zza, com.google.android.gms.ads.zzb.zzd(zzqVar.zze, zzqVar.zzb));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() && zzeznVar.zzah) {
                zza = new com.google.android.gms.ads.internal.client.zzq(this.zza, com.google.android.gms.ads.zzb.zze(zzqVar.zze, zzqVar.zzb));
            } else {
                zza = zzfam.zza(this.zza, zzeznVar.zzv);
            }
        }
        com.google.android.gms.ads.internal.client.zzq zzqVar2 = zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() && zzeznVar.zzah) {
            ((zzfbd) zzecfVar.zzb).zzn(this.zza, zzqVar2, zzezzVar.zza.zza.zzd, zzeznVar.zzw.toString(), com.google.android.gms.ads.internal.util.zzbu.zzl(zzeznVar.zzt), (zzboc) zzecfVar.zzc);
        } else {
            ((zzfbd) zzecfVar.zzb).zzm(this.zza, zzqVar2, zzezzVar.zza.zza.zzd, zzeznVar.zzw.toString(), com.google.android.gms.ads.internal.util.zzbu.zzl(zzeznVar.zzt), (zzboc) zzecfVar.zzc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(View view, zzezn zzeznVar, Object obj) throws Exception {
        return zzfwc.zzh(zzcqp.zza(this.zza, view, zzeznVar));
    }
}
