package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcuk {
    private final zzfel zza;
    private final zzbzx zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzgvy zzg;
    private final String zzh;
    private final zzerb zzi;
    private final com.google.android.gms.ads.internal.util.zzg zzj;
    private final zzfai zzk;

    public zzcuk(zzfel zzfelVar, zzbzx zzbzxVar, ApplicationInfo applicationInfo, String str, List list, @Nullable PackageInfo packageInfo, zzgvy zzgvyVar, com.google.android.gms.ads.internal.util.zzg zzgVar, String str2, zzerb zzerbVar, zzfai zzfaiVar) {
        this.zza = zzfelVar;
        this.zzb = zzbzxVar;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzgvyVar;
        this.zzh = str2;
        this.zzi = zzerbVar;
        this.zzj = zzgVar;
        this.zzk = zzfaiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbue zza(zzfwm zzfwmVar) throws Exception {
        boolean z3;
        Bundle bundle = (Bundle) zzfwmVar.get();
        zzbzx zzbzxVar = this.zzb;
        ApplicationInfo applicationInfo = this.zzc;
        String str = this.zzd;
        List list = this.zze;
        PackageInfo packageInfo = this.zzf;
        String str2 = (String) ((zzfwm) this.zzg.zzb()).get();
        String str3 = this.zzh;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgV)).booleanValue() && this.zzj.zzP()) {
            z3 = true;
        } else {
            z3 = false;
        }
        return new zzbue(bundle, zzbzxVar, applicationInfo, str, list, packageInfo, str2, str3, null, null, z3, this.zzk.zzb());
    }

    public final zzfwm zzb() {
        zzfel zzfelVar = this.zza;
        return zzfdv.zzc(this.zzi.zza(new Bundle()), zzfef.SIGNALS, zzfelVar).zza();
    }

    public final zzfwm zzc() {
        final zzfwm zzb = zzb();
        return this.zza.zza(zzfef.REQUEST_PARCEL, zzb, (zzfwm) this.zzg.zzb()).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcuj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzcuk.this.zza(zzb);
            }
        }).zza();
    }
}
