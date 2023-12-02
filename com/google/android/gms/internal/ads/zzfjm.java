package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ShowFirstParty
/* loaded from: classes4.dex */
public final class zzfjm {
    private final Context zza;
    private final Looper zzb;

    public zzfjm(@NonNull Context context, @NonNull Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(@NonNull String str) {
        zzfka zza = zzfkc.zza();
        zza.zza(this.zza.getPackageName());
        zza.zzc(2);
        zzfjx zza2 = zzfjy.zza();
        zza2.zza(str);
        zza2.zzb(2);
        zza.zzb(zza2);
        new zzfjn(this.zza, this.zzb, (zzfkc) zza.zzal()).zza();
    }
}
