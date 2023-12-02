package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeqk implements zzeqx {
    @Nullable
    public final String zza;
    @Nullable
    public final String zzb;
    @Nullable
    public final String zzc;
    @Nullable
    public final String zzd;
    @Nullable
    public final Long zze;

    public zzeqk(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Long l4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = l4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfat.zzc(bundle, "gmp_app_id", this.zza);
        zzfat.zzc(bundle, "fbs_aiid", this.zzb);
        zzfat.zzc(bundle, "fbs_aeid", this.zzc);
        zzfat.zzc(bundle, "apm_id_origin", this.zzd);
        Long l4 = this.zze;
        if (l4 != null) {
            bundle.putLong("sai_timeout", l4.longValue());
        }
    }
}
