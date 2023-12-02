package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzelt implements zzeqx {
    private final com.google.android.gms.ads.internal.client.zzw zza;
    private final zzbzx zzb;
    private final boolean zzc;

    public zzelt(com.google.android.gms.ads.internal.client.zzw zzwVar, zzbzx zzbzxVar, boolean z3) {
        this.zza = zzwVar;
        this.zzb = zzbzxVar;
        this.zzc = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzb.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeX)).intValue()) {
            bundle.putString("app_open_version", ExifInterface.GPS_MEASUREMENT_2D);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeY)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzc);
        }
        com.google.android.gms.ads.internal.client.zzw zzwVar = this.zza;
        if (zzwVar != null) {
            int i4 = zzwVar.zza;
            if (i4 == 1) {
                bundle.putString("avo", "p");
            } else if (i4 == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
