package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdgt implements zzaua {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdgv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgt(zzdgv zzdgvVar, String str) {
        this.zzb = zzdgvVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzc(zzatz zzatzVar) {
        Map map;
        zzdiw zzdiwVar;
        zzdiw zzdiwVar2;
        zzdiw zzdiwVar3;
        zzdiw zzdiwVar4;
        Map map2;
        zzdiw zzdiwVar5;
        zzdiw zzdiwVar6;
        zzdiw zzdiwVar7;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbD)).booleanValue()) {
            synchronized (this) {
                if (zzatzVar.zzj) {
                    zzdgv zzdgvVar = this.zzb;
                    zzdiwVar4 = zzdgvVar.zzo;
                    if (zzdiwVar4 != null) {
                        map2 = zzdgvVar.zzy;
                        map2.put(this.zza, Boolean.TRUE);
                        zzdgv zzdgvVar2 = this.zzb;
                        zzdiwVar5 = zzdgvVar2.zzo;
                        View zzf = zzdiwVar5.zzf();
                        zzdiwVar6 = this.zzb.zzo;
                        Map zzl = zzdiwVar6.zzl();
                        zzdiwVar7 = this.zzb.zzo;
                        zzdgvVar2.zzA(zzf, zzl, zzdiwVar7.zzm(), true);
                    }
                }
            }
        } else if (zzatzVar.zzj) {
            map = this.zzb.zzy;
            map.put(this.zza, Boolean.TRUE);
            zzdgv zzdgvVar3 = this.zzb;
            zzdiwVar = zzdgvVar3.zzo;
            View zzf2 = zzdiwVar.zzf();
            zzdiwVar2 = this.zzb.zzo;
            Map zzl2 = zzdiwVar2.zzl();
            zzdiwVar3 = this.zzb.zzo;
            zzdgvVar3.zzA(zzf2, zzl2, zzdiwVar3.zzm(), true);
        }
    }
}
