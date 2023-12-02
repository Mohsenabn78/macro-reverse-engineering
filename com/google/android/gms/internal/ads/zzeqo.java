package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.mlkit.nl.translate.TranslateLanguage;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeqo implements zzeqx {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    @Nullable
    public final String zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeqo(boolean z3, boolean z4, String str, boolean z5, int i4, int i5, int i6, @Nullable String str2) {
        this.zza = z3;
        this.zzb = z4;
        this.zzc = str;
        this.zzd = z5;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.zzc);
        bundle.putBoolean("is_nonagon", true);
        bundle.putString("extra_caps", (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzds));
        bundle.putInt("target_api", this.zze);
        bundle.putInt("dv", this.zzf);
        bundle.putInt(TranslateLanguage.LATVIAN, this.zzg);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfI)).booleanValue() && !TextUtils.isEmpty(this.zzh)) {
            bundle.putString("ev", this.zzh);
        }
        Bundle zza = zzfat.zza(bundle, "sdk_env");
        zza.putBoolean("mf", ((Boolean) zzbdf.zza.zze()).booleanValue());
        zza.putBoolean("instant_app", this.zza);
        zza.putBoolean("lite", this.zzb);
        zza.putBoolean("is_privileged_process", this.zzd);
        bundle.putBundle("sdk_env", zza);
        Bundle zza2 = zzfat.zza(zza, "build_meta");
        zza2.putString("cl", "549114221");
        zza2.putString("rapid_rc", "dev");
        zza2.putString("rapid_rollup", "HEAD");
        zza.putBundle("build_meta", zza2);
    }
}
