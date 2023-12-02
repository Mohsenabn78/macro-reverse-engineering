package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbnk implements zzbiw {
    final /* synthetic */ zzbnl zza;
    private final zzcaj zzb;

    public zzbnk(zzbnl zzbnlVar, zzcaj zzcajVar) {
        this.zza = zzbnlVar;
        this.zzb = zzcajVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbiw
    public final void zza(@Nullable String str) {
        try {
            if (str == null) {
                this.zzb.zze(new zzbmo());
            } else {
                this.zzb.zze(new zzbmo(str));
            }
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbiw
    public final void zzb(JSONObject jSONObject) {
        try {
            this.zzb.zzd(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e4) {
            this.zzb.zze(e4);
        }
    }
}
