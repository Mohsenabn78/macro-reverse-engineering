package com.google.android.gms.internal.nearby;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzmn {
    private final zzmp zza = new zzmp(null);

    public final zzmn zza(@Nullable zzmc zzmcVar) {
        this.zza.zzc = zzmcVar;
        return this;
    }

    public final zzmn zzb(String[] strArr) {
        this.zza.zzb = strArr;
        return this;
    }

    public final zzmn zzc(@Nullable zzkk zzkkVar) {
        this.zza.zza = zzkkVar;
        return this;
    }

    public final zzmp zzd() {
        return this.zza;
    }
}
