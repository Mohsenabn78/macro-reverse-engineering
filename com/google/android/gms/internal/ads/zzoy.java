package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzoy extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzam zzc;

    public zzoy(int i4, zzam zzamVar, boolean z3) {
        super("AudioTrack write failed: " + i4);
        this.zzb = z3;
        this.zza = i4;
        this.zzc = zzamVar;
    }
}
