package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeep implements zzece {
    private final zzdnv zza;

    public zzeep(zzdnv zzdnvVar) {
        this.zza = zzdnvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzece
    @Nullable
    public final zzecf zza(String str, JSONObject jSONObject) throws zzfan {
        return new zzecf(this.zza.zzc(str, jSONObject), new zzedy(), str);
    }
}
