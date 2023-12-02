package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzacv implements zzaah {
    private final zzabj zza;
    private final int zzb;
    private final zzabe zzc = new zzabe();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzacv(zzabj zzabjVar, int i4, zzacu zzacuVar) {
        this.zza = zzabjVar;
        this.zzb = i4;
    }

    private final long zzc(zzaax zzaaxVar) throws IOException {
        while (zzaaxVar.zze() < zzaaxVar.zzd() - 6) {
            zzabj zzabjVar = this.zza;
            int i4 = this.zzb;
            zzabe zzabeVar = this.zzc;
            long zze = zzaaxVar.zze();
            byte[] bArr = new byte[2];
            zzaam zzaamVar = (zzaam) zzaaxVar;
            zzaamVar.zzm(bArr, 0, 2, false);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i4) {
                zzaaxVar.zzj();
                zzaamVar.zzl((int) (zze - zzaaxVar.zzf()), false);
            } else {
                zzfa zzfaVar = new zzfa(16);
                System.arraycopy(bArr, 0, zzfaVar.zzH(), 0, 2);
                zzfaVar.zzE(zzaba.zza(zzaaxVar, zzfaVar.zzH(), 2, 14));
                zzaaxVar.zzj();
                zzaamVar.zzl((int) (zze - zzaaxVar.zzf()), false);
                if (zzabf.zzc(zzfaVar, zzabjVar, i4, zzabeVar)) {
                    break;
                }
            }
            zzaamVar.zzl(1, false);
        }
        if (zzaaxVar.zze() >= zzaaxVar.zzd() - 6) {
            ((zzaam) zzaaxVar).zzl((int) (zzaaxVar.zzd() - zzaaxVar.zze()), false);
            return this.zza.zzj;
        }
        return this.zzc.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final zzaag zza(zzaax zzaaxVar, long j4) throws IOException {
        long zzf = zzaaxVar.zzf();
        long zzc = zzc(zzaaxVar);
        long zze = zzaaxVar.zze();
        ((zzaam) zzaaxVar).zzl(Math.max(6, this.zza.zzc), false);
        int i4 = (zzc > j4 ? 1 : (zzc == j4 ? 0 : -1));
        long zzc2 = zzc(zzaaxVar);
        long zze2 = zzaaxVar.zze();
        if (i4 <= 0 && zzc2 > j4) {
            return zzaag.zze(zze);
        }
        if (zzc2 <= j4) {
            return zzaag.zzf(zzc2, zze2);
        }
        return zzaag.zzd(zzc, zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final /* synthetic */ void zzb() {
    }
}
