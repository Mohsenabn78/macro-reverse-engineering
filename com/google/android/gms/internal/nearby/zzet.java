package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzet {
    private final zzev zza = new zzev(null);

    public final zzet zza(IStatusCallback iStatusCallback) {
        this.zza.zza = iStatusCallback;
        return this;
    }

    public final zzev zzb() {
        return this.zza;
    }
}
