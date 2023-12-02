package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public final class zzln {
    private final zzir zza;

    @Deprecated
    public zzln(Context context, zzcei zzceiVar) {
        this.zza = new zzir(context, zzceiVar);
    }

    @Deprecated
    public final zzln zza(final zzkk zzkkVar) {
        zzir zzirVar = this.zza;
        zzdy.zzf(!zzirVar.zzq);
        zzkkVar.getClass();
        zzirVar.zzf = new zzfpx() { // from class: com.google.android.gms.internal.ads.zzij
            @Override // com.google.android.gms.internal.ads.zzfpx
            public final Object zza() {
                return zzkk.this;
            }
        };
        return this;
    }

    @Deprecated
    public final zzln zzb(final zzxg zzxgVar) {
        zzir zzirVar = this.zza;
        zzdy.zzf(!zzirVar.zzq);
        zzxgVar.getClass();
        zzirVar.zze = new zzfpx() { // from class: com.google.android.gms.internal.ads.zzik
            @Override // com.google.android.gms.internal.ads.zzfpx
            public final Object zza() {
                return zzxg.this;
            }
        };
        return this;
    }

    @Deprecated
    public final zzlo zzc() {
        zzir zzirVar = this.zza;
        zzdy.zzf(!zzirVar.zzq);
        zzirVar.zzq = true;
        return new zzlo(zzirVar);
    }
}
