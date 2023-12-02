package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzeh {
    private final zzej zza = new zzej(null);

    public final zzeh zza(boolean z3) {
        this.zza.zzb = z3;
        return this;
    }

    public final zzeh zzb(IStatusCallback iStatusCallback) {
        this.zza.zza = iStatusCallback;
        return this;
    }

    public final zzej zzc() {
        return this.zza;
    }
}
