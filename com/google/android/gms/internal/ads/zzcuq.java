package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcuq {
    private final Context zza;
    private final zzfai zzb;
    private final Bundle zzc;
    @Nullable
    private final zzfaa zzd;
    @Nullable
    private final zzcui zze;
    @Nullable
    private final zzech zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcuq(zzcuo zzcuoVar, zzcup zzcupVar) {
        this.zza = zzcuo.zza(zzcuoVar);
        this.zzb = zzcuo.zzm(zzcuoVar);
        this.zzc = zzcuo.zzb(zzcuoVar);
        this.zzd = zzcuo.zzl(zzcuoVar);
        this.zze = zzcuo.zzc(zzcuoVar);
        this.zzf = zzcuo.zzk(zzcuoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context zza(Context context) {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Bundle zzb() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzcui zzc() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcuo zzd() {
        zzcuo zzcuoVar = new zzcuo();
        zzcuoVar.zze(this.zza);
        zzcuoVar.zzi(this.zzb);
        zzcuoVar.zzf(this.zzc);
        zzcuoVar.zzg(this.zze);
        zzcuoVar.zzd(this.zzf);
        return zzcuoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzech zze(String str) {
        zzech zzechVar = this.zzf;
        if (zzechVar != null) {
            return zzechVar;
        }
        return new zzech(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzfaa zzf() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfai zzg() {
        return this.zzb;
    }
}
