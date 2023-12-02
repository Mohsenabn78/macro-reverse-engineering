package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfih {
    private JSONObject zza;
    private final zzfiq zzb;

    public zzfih(zzfiq zzfiqVar) {
        this.zzb = zzfiqVar;
    }

    @VisibleForTesting
    public final JSONObject zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zzb.zzb(new zzfir(this));
    }

    public final void zzc(JSONObject jSONObject, HashSet hashSet, long j4) {
        this.zzb.zzb(new zzfis(this, hashSet, jSONObject, j4));
    }

    public final void zzd(JSONObject jSONObject, HashSet hashSet, long j4) {
        this.zzb.zzb(new zzfit(this, hashSet, jSONObject, j4));
    }

    @VisibleForTesting
    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
