package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcuo {
    private Context zza;
    private zzfai zzb;
    private Bundle zzc;
    @Nullable
    private zzfaa zzd;
    @Nullable
    private zzcui zze;
    @Nullable
    private zzech zzf;

    public final zzcuo zzd(@Nullable zzech zzechVar) {
        this.zzf = zzechVar;
        return this;
    }

    public final zzcuo zze(Context context) {
        this.zza = context;
        return this;
    }

    public final zzcuo zzf(Bundle bundle) {
        this.zzc = bundle;
        return this;
    }

    public final zzcuo zzg(@Nullable zzcui zzcuiVar) {
        this.zze = zzcuiVar;
        return this;
    }

    public final zzcuo zzh(zzfaa zzfaaVar) {
        this.zzd = zzfaaVar;
        return this;
    }

    public final zzcuo zzi(zzfai zzfaiVar) {
        this.zzb = zzfaiVar;
        return this;
    }

    public final zzcuq zzj() {
        return new zzcuq(this, null);
    }
}
