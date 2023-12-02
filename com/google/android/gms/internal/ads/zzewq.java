package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzewq implements zzexe {
    private final zzfbu zza;
    private final Executor zzb;
    private final zzfvy zzc = new zzewo(this);

    public zzewq(zzfbu zzfbuVar, Executor executor) {
        this.zza = zzfbuVar;
        this.zzb = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zza(zzcun zzcunVar, zzewz zzewzVar) throws Exception {
        zzfce zzfceVar = zzewzVar.zzb;
        zzbue zzbueVar = zzewzVar.zza;
        zzfcd zzb = this.zza.zzb(zzfceVar);
        if (zzb != null && zzbueVar != null) {
            zzfwc.zzq(zzcunVar.zzb().zzh(zzbueVar), this.zzc, this.zzb);
        }
        return zzfwc.zzh(new zzewp(zzfceVar, zzbueVar, zzb));
    }

    public final zzfwm zzb(zzexf zzexfVar, zzexd zzexdVar, final zzcun zzcunVar) {
        return zzfwc.zze(zzfwc.zzm(zzfvt.zzv(new zzexa(this.zza, zzcunVar, this.zzb).zzc()), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzewm
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzewq.this.zza(zzcunVar, (zzewz) obj);
            }
        }, this.zzb), Exception.class, new zzewn(this), this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzexe
    public final /* bridge */ /* synthetic */ zzfwm zzc(zzexf zzexfVar, zzexd zzexdVar, Object obj) {
        return zzb(zzexfVar, zzexdVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzexe
    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
