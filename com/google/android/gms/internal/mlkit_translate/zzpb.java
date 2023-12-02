package com.google.android.gms.internal.mlkit_translate;

import javax.annotation.concurrent.Immutable;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
@Immutable
/* loaded from: classes4.dex */
final class zzpb {
    private final zzop zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;

    public zzpb(zzop zzopVar, String str, String str2, long j4) {
        this.zza = zzopVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j4;
    }

    public final long zza() {
        return this.zzd;
    }

    public final zzop zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        if (System.currentTimeMillis() >= this.zzd) {
            return true;
        }
        return false;
    }
}
