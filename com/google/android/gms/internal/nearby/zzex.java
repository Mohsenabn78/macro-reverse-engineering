package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzex {
    private final zzez zza = new zzez((zzey) null);

    public final zzex zza(IStatusCallback iStatusCallback) {
        this.zza.zza = iStatusCallback;
        return this;
    }

    public final zzez zzb() {
        return this.zza;
    }
}
