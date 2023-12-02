package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzems implements zzeqx {
    public final double zza;
    public final boolean zzb;

    public zzems(double d4, boolean z3) {
        this.zza = d4;
        this.zzb = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzfat.zza(bundle, "device");
        bundle.putBundle("device", zza);
        Bundle zza2 = zzfat.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.zzb);
        zza2.putDouble("battery_level", this.zza);
    }
}
