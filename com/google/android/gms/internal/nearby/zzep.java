package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzep {
    private final zzer zza = new zzer(null);

    public final zzep zza(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        this.zza.zzb = diagnosisKeysDataMapping;
        return this;
    }

    public final zzep zzb(IStatusCallback iStatusCallback) {
        this.zza.zza = iStatusCallback;
        return this;
    }

    public final zzer zzc() {
        return this.zza;
    }
}
