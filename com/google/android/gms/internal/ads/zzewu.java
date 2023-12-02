package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzewu implements zzexe {
    private final zzexe zza;
    @Nullable
    private zzcun zzb;

    public zzewu(zzexe zzexeVar) {
        this.zza = zzexeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexe
    /* renamed from: zza */
    public final synchronized zzcun zzd() {
        return this.zzb;
    }

    public final synchronized zzfwm zzb(zzexf zzexfVar, zzexd zzexdVar, @Nullable zzcun zzcunVar) {
        this.zzb = zzcunVar;
        if (zzexfVar.zza != null) {
            zzcsk zzb = zzcunVar.zzb();
            return zzb.zzi(zzb.zzk(zzfwc.zzh(zzexfVar.zza)));
        }
        return ((zzewt) this.zza).zzb(zzexfVar, zzexdVar, zzcunVar);
    }

    @Override // com.google.android.gms.internal.ads.zzexe
    public final /* bridge */ /* synthetic */ zzfwm zzc(zzexf zzexfVar, zzexd zzexdVar, @Nullable Object obj) {
        return zzb(zzexfVar, zzexdVar, null);
    }
}
