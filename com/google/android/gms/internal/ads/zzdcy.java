package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdcy {
    private final List zza;
    private final zzfgr zzb;
    private boolean zzc;

    public zzdcy(zzezn zzeznVar, zzfgr zzfgrVar) {
        this.zza = zzeznVar.zzq;
        this.zzb = zzfgrVar;
    }

    public final void zza() {
        if (!this.zzc) {
            this.zzb.zzd(this.zza);
            this.zzc = true;
        }
    }
}
