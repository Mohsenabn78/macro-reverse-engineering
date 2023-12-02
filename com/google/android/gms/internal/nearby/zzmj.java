package com.google.android.gms.internal.nearby;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.connection.ConnectionOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzmj {
    private final zzml zza = new zzml(null);

    public final zzmj zza(@Nullable zzjt zzjtVar) {
        this.zza.zzb = zzjtVar;
        return this;
    }

    public final zzmj zzb(@Nullable zzjw zzjwVar) {
        this.zza.zzg = zzjwVar;
        return this;
    }

    public final zzmj zzc(@Nullable zzjz zzjzVar) {
        this.zza.zzc = zzjzVar;
        return this;
    }

    public final zzmj zzd(@Nullable byte[] bArr) {
        this.zza.zzh = bArr;
        return this;
    }

    public final zzmj zze(@Nullable byte[] bArr) {
        this.zza.zzf = bArr;
        return this;
    }

    public final zzmj zzf(@Nullable String str) {
        this.zza.zzd = str;
        return this;
    }

    public final zzmj zzg(@Nullable ConnectionOptions connectionOptions) {
        this.zza.zzi = connectionOptions;
        return this;
    }

    public final zzmj zzh(String str) {
        this.zza.zze = str;
        return this;
    }

    public final zzmj zzi(@Nullable zzkk zzkkVar) {
        this.zza.zza = zzkkVar;
        return this;
    }

    public final zzml zzj() {
        return this.zza;
    }
}
