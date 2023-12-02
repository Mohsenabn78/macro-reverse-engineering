package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzahc {
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final zzam zzf;
    public final int zzg;
    @Nullable
    public final long[] zzh;
    @Nullable
    public final long[] zzi;
    public final int zzj;
    @Nullable
    private final zzahd[] zzk;

    public zzahc(int i4, int i5, long j4, long j5, long j6, zzam zzamVar, int i6, @Nullable zzahd[] zzahdVarArr, int i7, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = j4;
        this.zzd = j5;
        this.zze = j6;
        this.zzf = zzamVar;
        this.zzg = i6;
        this.zzk = zzahdVarArr;
        this.zzj = i7;
        this.zzh = jArr;
        this.zzi = jArr2;
    }

    @Nullable
    public final zzahd zza(int i4) {
        return this.zzk[i4];
    }
}
