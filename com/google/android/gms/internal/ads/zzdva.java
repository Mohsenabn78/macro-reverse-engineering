package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzdva implements zzfvy {
    final /* synthetic */ zzdvb zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdva(zzdvb zzdvbVar) {
        this.zza = zzdvbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        Pattern pattern;
        zzdzx zzdzxVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfW)).booleanValue()) {
            pattern = zzdvb.zza;
            Matcher matcher = pattern.matcher(th.getMessage());
            if (matcher.matches()) {
                String group = matcher.group(1);
                zzdzxVar = this.zza.zzf;
                zzdzxVar.zzi(Integer.parseInt(group));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdzx zzdzxVar;
        zzdzx zzdzxVar2;
        zzezz zzezzVar = (zzezz) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfW)).booleanValue()) {
            zzdzxVar = this.zza.zzf;
            zzdzxVar.zzi(zzezzVar.zzb.zzb.zze);
            zzdzxVar2 = this.zza.zzf;
            zzdzxVar2.zzj(zzezzVar.zzb.zzb.zzf);
        }
    }
}
