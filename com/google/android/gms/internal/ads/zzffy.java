package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.AdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzffy implements Runnable {
    private final zzfgb zzb;
    private String zzc;
    private String zzd;
    private zzezy zze;
    private com.google.android.gms.ads.internal.client.zze zzf;
    private Future zzg;
    private final List zza = new ArrayList();
    private int zzh = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzffy(zzfgb zzfgbVar) {
        this.zzb = zzfgbVar;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        zzg();
    }

    public final synchronized zzffy zza(zzffn zzffnVar) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            List list = this.zza;
            zzffnVar.zzi();
            list.add(zzffnVar);
            Future future = this.zzg;
            if (future != null) {
                future.cancel(false);
            }
            this.zzg = zzcae.zzd.schedule(this, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzin)).intValue(), TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public final synchronized zzffy zzb(String str) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue() && zzffx.zze(str)) {
            this.zzc = str;
        }
        return this;
    }

    public final synchronized zzffy zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            this.zzf = zzeVar;
        }
        return this;
    }

    public final synchronized zzffy zzd(ArrayList arrayList) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            if (!arrayList.contains("banner") && !arrayList.contains(AdFormat.BANNER.name())) {
                if (!arrayList.contains("interstitial") && !arrayList.contains(AdFormat.INTERSTITIAL.name())) {
                    if (!arrayList.contains("native") && !arrayList.contains(AdFormat.NATIVE.name())) {
                        if (!arrayList.contains("rewarded") && !arrayList.contains(AdFormat.REWARDED.name())) {
                            if (arrayList.contains("app_open_ad")) {
                                this.zzh = 7;
                            } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains(AdFormat.REWARDED_INTERSTITIAL.name())) {
                                this.zzh = 6;
                            }
                        }
                        this.zzh = 5;
                    }
                    this.zzh = 8;
                }
                this.zzh = 4;
            }
            this.zzh = 3;
        }
        return this;
    }

    public final synchronized zzffy zze(String str) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            this.zzd = str;
        }
        return this;
    }

    public final synchronized zzffy zzf(zzezy zzezyVar) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            this.zze = zzezyVar;
        }
        return this;
    }

    public final synchronized void zzg() {
        if (!((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            return;
        }
        Future future = this.zzg;
        if (future != null) {
            future.cancel(false);
        }
        for (zzffn zzffnVar : this.zza) {
            int i4 = this.zzh;
            if (i4 != 2) {
                zzffnVar.zzm(i4);
            }
            if (!TextUtils.isEmpty(this.zzc)) {
                zzffnVar.zze(this.zzc);
            }
            if (!TextUtils.isEmpty(this.zzd) && !zzffnVar.zzk()) {
                zzffnVar.zzd(this.zzd);
            }
            zzezy zzezyVar = this.zze;
            if (zzezyVar != null) {
                zzffnVar.zzb(zzezyVar);
            } else {
                com.google.android.gms.ads.internal.client.zze zzeVar = this.zzf;
                if (zzeVar != null) {
                    zzffnVar.zza(zzeVar);
                }
            }
            this.zzb.zzb(zzffnVar.zzl());
        }
        this.zza.clear();
    }

    public final synchronized zzffy zzh(int i4) {
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            this.zzh = i4;
        }
        return this;
    }
}
