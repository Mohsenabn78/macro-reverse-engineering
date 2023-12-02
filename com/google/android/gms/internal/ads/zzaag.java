package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaag {
    public static final zzaag zza = new zzaag(-3, -9223372036854775807L, -1);
    private final int zzb;
    private final long zzc;
    private final long zzd;

    private zzaag(int i4, long j4, long j5) {
        this.zzb = i4;
        this.zzc = j4;
        this.zzd = j5;
    }

    public static zzaag zzd(long j4, long j5) {
        return new zzaag(-1, j4, j5);
    }

    public static zzaag zze(long j4) {
        return new zzaag(0, -9223372036854775807L, j4);
    }

    public static zzaag zzf(long j4, long j5) {
        return new zzaag(-2, j4, j5);
    }
}
