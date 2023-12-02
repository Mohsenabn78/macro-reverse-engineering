package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.mlkit.nl.translate.TranslateLanguage;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzerh implements zzeqx {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final boolean zze;
    public final int zzf;

    public zzerh(String str, int i4, int i5, int i6, boolean z3, int i7) {
        this.zza = str;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
        this.zze = z3;
        this.zzf = i7;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.zza;
        boolean z3 = true;
        zzfat.zzf(bundle, "carrier", str, !TextUtils.isEmpty(str));
        int i4 = this.zzb;
        if (i4 == -2) {
            z3 = false;
        }
        zzfat.zze(bundle, "cnt", i4, z3);
        bundle.putInt("gnt", this.zzc);
        bundle.putInt(TranslateLanguage.PORTUGUESE, this.zzd);
        Bundle zza = zzfat.zza(bundle, "device");
        bundle.putBundle("device", zza);
        Bundle zza2 = zzfat.zza(zza, "network");
        zza.putBundle("network", zza2);
        zza2.putInt("active_network_state", this.zzf);
        zza2.putBoolean("active_network_metered", this.zze);
    }
}
