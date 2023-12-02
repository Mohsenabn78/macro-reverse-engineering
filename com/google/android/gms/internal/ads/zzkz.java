package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzkz implements zzkq {
    public final zztj zza;
    public int zzd;
    public boolean zze;
    public final List zzc = new ArrayList();
    public final Object zzb = new Object();

    public zzkz(zztq zztqVar, boolean z3) {
        this.zza = new zztj(zztqVar, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzkq
    public final zzcw zza() {
        return this.zza.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzkq
    public final Object zzb() {
        return this.zzb;
    }

    public final void zzc(int i4) {
        this.zzd = i4;
        this.zze = false;
        this.zzc.clear();
    }
}
