package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzakf {
    public final int zza;
    public final long zzb;

    private zzakf(int i4, long j4) {
        this.zza = i4;
        this.zzb = j4;
    }

    public static zzakf zza(zzaax zzaaxVar, zzfa zzfaVar) throws IOException {
        ((zzaam) zzaaxVar).zzm(zzfaVar.zzH(), 0, 8, false);
        zzfaVar.zzF(0);
        return new zzakf(zzfaVar.zze(), zzfaVar.zzq());
    }
}
