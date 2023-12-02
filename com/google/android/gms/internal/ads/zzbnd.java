package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbnd implements zzbmp {
    private final zzbmr zza;
    private final zzbms zzb;
    private final zzbml zzc;
    private final String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbnd(zzbml zzbmlVar, String str, zzbms zzbmsVar, zzbmr zzbmrVar) {
        this.zzc = zzbmlVar;
        this.zzd = str;
        this.zzb = zzbmsVar;
        this.zza = zzbmrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzd(zzbnd zzbndVar, zzbmf zzbmfVar, zzbmm zzbmmVar, Object obj, zzcaj zzcajVar) {
        try {
            com.google.android.gms.ads.internal.zzt.zzp();
            String uuid = UUID.randomUUID().toString();
            zzbii.zzo.zzc(uuid, new zzbnc(zzbndVar, zzbmfVar, zzcajVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", uuid);
            jSONObject.put("args", zzbndVar.zzb.zzb(obj));
            zzbmmVar.zzl(zzbndVar.zzd, jSONObject);
        } catch (Exception e4) {
            try {
                zzcajVar.zze(e4);
                zzbzr.zzh("Unable to invokeJavascript", e4);
            } finally {
                zzbmfVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvj
    public final zzfwm zza(@Nullable Object obj) throws Exception {
        return zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final zzfwm zzb(Object obj) {
        zzcaj zzcajVar = new zzcaj();
        zzbmf zzb = this.zzc.zzb(null);
        zzb.zzi(new zzbna(this, zzb, obj, zzcajVar), new zzbnb(this, zzcajVar, zzb));
        return zzcajVar;
    }
}
