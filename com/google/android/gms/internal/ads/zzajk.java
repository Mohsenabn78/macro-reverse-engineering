package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzajk {
    private final List zza;
    private final zzabz[] zzb;

    public zzajk(List list) {
        this.zza = list;
        this.zzb = new zzabz[list.size()];
    }

    public final void zza(long j4, zzfa zzfaVar) {
        zzaaj.zza(j4, zzfaVar, this.zzb);
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
            String str2 = zzamVar.zzb;
            if (str2 == null) {
                str2 = zzajvVar.zzb();
            }
            zzak zzakVar = new zzak();
            zzakVar.zzH(str2);
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
