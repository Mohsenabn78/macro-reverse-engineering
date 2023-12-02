package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfbo implements zzcvj {
    private final HashSet zza = new HashSet();
    private final Context zzb;
    private final zzbze zzc;

    public zzfbo(Context context, zzbze zzbzeVar) {
        this.zzb = context;
        this.zzc = zzbzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvj
    public final synchronized void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (zzeVar.zza != 3) {
            this.zzc.zzj(this.zza);
        }
    }

    public final Bundle zzb() {
        return this.zzc.zzl(this.zzb, this);
    }

    public final synchronized void zzc(HashSet hashSet) {
        this.zza.clear();
        this.zza.addAll(hashSet);
    }
}
