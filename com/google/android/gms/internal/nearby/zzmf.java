package com.google.android.gms.internal.nearby;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzmf {
    private final zzmh zza = new zzmh(null);

    public final zzmf zza(String str) {
        this.zza.zzb = str;
        return this;
    }

    public final zzmf zzb(@Nullable zzkk zzkkVar) {
        this.zza.zza = zzkkVar;
        return this;
    }

    public final zzmh zzc() {
        return this.zza;
    }
}
