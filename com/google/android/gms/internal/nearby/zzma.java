package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzma {
    private final zzmc zza = new zzmc(null);

    public final zzma zza(@Nullable byte[] bArr) {
        this.zza.zzc = bArr;
        return this;
    }

    public final zzma zzb(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzd = parcelFileDescriptor;
        return this;
    }

    public final zzma zzc(@Nullable String str) {
        this.zza.zzm = str;
        return this;
    }

    public final zzma zzd(long j4) {
        this.zza.zza = j4;
        return this;
    }

    public final zzma zze(boolean z3) {
        this.zza.zzj = z3;
        return this;
    }

    public final zzma zzf(@Nullable String str) {
        this.zza.zze = str;
        return this;
    }

    public final zzma zzg(long j4) {
        this.zza.zzf = j4;
        return this;
    }

    public final zzma zzh(long j4) {
        this.zza.zzi = j4;
        return this;
    }

    public final zzma zzi(@Nullable String str) {
        this.zza.zzn = str;
        return this;
    }

    public final zzma zzj(long j4) {
        this.zza.zzl = 0L;
        return this;
    }

    public final zzma zzk(@Nullable zzly zzlyVar) {
        this.zza.zzk = zzlyVar;
        return this;
    }

    public final zzma zzl(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzg = parcelFileDescriptor;
        return this;
    }

    public final zzma zzm(int i4) {
        this.zza.zzb = i4;
        return this;
    }

    public final zzmc zzn() {
        return this.zza;
    }
}
