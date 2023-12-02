package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeha implements zzece {
    private final zzeie zza;

    public zzeha(zzeie zzeieVar) {
        this.zza = zzeieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzece
    @Nullable
    public final zzecf zza(String str, JSONObject jSONObject) throws zzfan {
        zzbpt zza = this.zza.zza(str);
        if (zza == null) {
            return null;
        }
        return new zzecf(zza, new zzedy(), str);
    }
}
