package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcdp extends zzcdl {
    public zzcdp(zzcca zzccaVar) {
        super(zzccaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcdl
    public final boolean zzt(String str) {
        String zze = zzbzk.zze(str);
        zzcca zzccaVar = (zzcca) this.zzc.get();
        if (zzccaVar != null && zze != null) {
            zzccaVar.zzt(zze, this);
        }
        zzbzr.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, zze, "noop", "Noop cache is a noop.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcdl
    public final void zzf() {
    }
}
