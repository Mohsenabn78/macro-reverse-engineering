package com.google.android.gms.internal.nearby;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzed {
    private final zzef zza = new zzef(null);

    public final zzed zza(@Nullable zzcv zzcvVar) {
        this.zza.zzf = zzcvVar;
        return this;
    }

    public final zzed zzb(ExposureConfiguration exposureConfiguration) {
        this.zza.zzd = exposureConfiguration;
        return this;
    }

    public final zzed zzc(List list) {
        this.zza.zzc = list;
        return this;
    }

    public final zzed zzd(IStatusCallback iStatusCallback) {
        this.zza.zzb = iStatusCallback;
        return this;
    }

    public final zzed zze(String str) {
        this.zza.zze = str;
        return this;
    }

    public final zzef zzf() {
        return this.zza;
    }
}
