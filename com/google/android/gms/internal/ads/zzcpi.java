package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzcpi {
    private final zzcrb zza;
    private final View zzb;
    private final zzezo zzc;
    @Nullable
    private final zzcez zzd;

    public zzcpi(View view, @Nullable zzcez zzcezVar, zzcrb zzcrbVar, zzezo zzezoVar) {
        this.zzb = view;
        this.zzd = zzcezVar;
        this.zza = zzcrbVar;
        this.zzc = zzezoVar;
    }

    public static final zzdcm zzf(final Context context, final zzbzx zzbzxVar, final zzezn zzeznVar, final zzfai zzfaiVar) {
        return new zzdcm(new zzcwu() { // from class: com.google.android.gms.internal.ads.zzcpg
            @Override // com.google.android.gms.internal.ads.zzcwu
            public final void zzn() {
                com.google.android.gms.ads.internal.zzt.zzs().zzn(context, zzbzxVar.zza, zzeznVar.zzD.toString(), zzfaiVar.zzf);
            }
        }, zzcae.zzf);
    }

    public static final Set zzg(zzcqs zzcqsVar) {
        return Collections.singleton(new zzdcm(zzcqsVar, zzcae.zzf));
    }

    public static final zzdcm zzh(zzcqq zzcqqVar) {
        return new zzdcm(zzcqqVar, zzcae.zze);
    }

    public final View zza() {
        return this.zzb;
    }

    @Nullable
    public final zzcez zzb() {
        return this.zzd;
    }

    public final zzcrb zzc() {
        return this.zza;
    }

    public zzcws zzd(Set set) {
        return new zzcws(set);
    }

    public final zzezo zze() {
        return this.zzc;
    }
}
