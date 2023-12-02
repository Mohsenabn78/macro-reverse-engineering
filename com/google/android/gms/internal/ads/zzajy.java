package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzajy {
    private final List zza;
    private final zzabz[] zzb;

    public zzajy(List list) {
        this.zza = list;
        this.zzb = new zzabz[list.size()];
    }

    public final void zza(long j4, zzfa zzfaVar) {
        if (zzfaVar.zza() < 9) {
            return;
        }
        int zze = zzfaVar.zze();
        int zze2 = zzfaVar.zze();
        int zzk = zzfaVar.zzk();
        if (zze == 434 && zze2 == 1195456820 && zzk == 3) {
            zzaaj.zzb(j4, zzfaVar, this.zzb);
        }
    }

    public final void zzb(zzaaz zzaazVar, zzajv zzajvVar) {
        for (int i4 = 0; i4 < this.zzb.length; i4++) {
            zzajvVar.zzc();
            zzabz zzv = zzaazVar.zzv(zzajvVar.zza(), 3);
            zzam zzamVar = (zzam) this.zza.get(i4);
            String str = zzamVar.zzm;
            boolean z3 = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z3 = false;
            }
            zzdy.zze(z3, "Invalid closed caption MIME type provided: ".concat(String.valueOf(str)));
            zzak zzakVar = new zzak();
            zzakVar.zzH(zzajvVar.zzb());
            zzakVar.zzS(str);
            zzakVar.zzU(zzamVar.zze);
            zzakVar.zzK(zzamVar.zzd);
            zzakVar.zzu(zzamVar.zzE);
            zzakVar.zzI(zzamVar.zzo);
            zzv.zzk(zzakVar.zzY());
            this.zzb[i4] = zzv;
        }
    }
}
