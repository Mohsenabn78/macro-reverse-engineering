package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzajl implements zzaah {
    private final zzfh zza;
    private final zzfa zzb = new zzfa();
    private final int zzc;

    public zzajl(int i4, zzfh zzfhVar, int i5) {
        this.zzc = i4;
        this.zza = zzfhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final zzaag zza(zzaax zzaaxVar, long j4) throws IOException {
        int zza;
        int zza2;
        long j5;
        long zzf = zzaaxVar.zzf();
        int min = (int) Math.min(112800L, zzaaxVar.zzd() - zzf);
        this.zzb.zzC(min);
        ((zzaam) zzaaxVar).zzm(this.zzb.zzH(), 0, min, false);
        zzfa zzfaVar = this.zzb;
        int zzd = zzfaVar.zzd();
        long j6 = -1;
        long j7 = -9223372036854775807L;
        long j8 = -1;
        while (zzfaVar.zza() >= 188 && (zza2 = (zza = zzajx.zza(zzfaVar.zzH(), zzfaVar.zzc(), zzd)) + 188) <= zzd) {
            long zzb = zzajx.zzb(zzfaVar, zza, this.zzc);
            if (zzb != -9223372036854775807L) {
                long zzb2 = this.zza.zzb(zzb);
                if (zzb2 > j4) {
                    if (j7 == -9223372036854775807L) {
                        return zzaag.zzd(zzb2, zzf);
                    }
                    j5 = zzf + j8;
                } else if (100000 + zzb2 > j4) {
                    j5 = zzf + zza;
                } else {
                    j8 = zza;
                    j7 = zzb2;
                }
                return zzaag.zze(j5);
            }
            zzfaVar.zzF(zza2);
            j6 = zza2;
        }
        if (j7 != -9223372036854775807L) {
            return zzaag.zzf(j7, zzf + j6);
        }
        return zzaag.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final void zzb() {
        zzfa zzfaVar = this.zzb;
        byte[] bArr = zzfj.zzf;
        int length = bArr.length;
        zzfaVar.zzD(bArr, 0);
    }
}
