package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzawx {
    private final InputStream zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final boolean zze;

    private zzawx(InputStream inputStream, boolean z3, boolean z4, long j4, boolean z5) {
        this.zza = inputStream;
        this.zzb = z3;
        this.zzc = z4;
        this.zzd = j4;
        this.zze = z5;
    }

    public static zzawx zzb(InputStream inputStream, boolean z3, boolean z4, long j4, boolean z5) {
        return new zzawx(inputStream, z3, z4, j4, z5);
    }

    public final long zza() {
        return this.zzd;
    }

    public final InputStream zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zze;
    }

    public final boolean zzf() {
        return this.zzc;
    }
}
