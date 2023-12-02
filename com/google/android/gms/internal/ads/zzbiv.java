package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbiv implements zzbiw {
    final /* synthetic */ zzcaj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbiv(zzbix zzbixVar, zzcaj zzcajVar) {
        this.zza = zzcajVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbiw
    public final void zza(@Nullable String str) {
        this.zza.zze(new zzbmo(str));
    }

    @Override // com.google.android.gms.internal.ads.zzbiw
    public final void zzb(JSONObject jSONObject) {
        this.zza.zzd(jSONObject);
    }
}
