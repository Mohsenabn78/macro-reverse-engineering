package com.google.android.gms.internal.ads;

import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbnl implements zzfvj {
    private final zzbmr zza;
    private final zzbms zzb;
    private final String zzc = "google.afma.activeView.handleUpdate";
    private final zzfwm zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbnl(zzfwm zzfwmVar, String str, zzbms zzbmsVar, zzbmr zzbmrVar) {
        this.zzd = zzfwmVar;
        this.zzb = zzbmsVar;
        this.zza = zzbmrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvj
    public final zzfwm zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final zzfwm zzb(final Object obj) {
        return zzfwc.zzm(this.zzd, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzbnj
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj2) {
                return zzbnl.this.zzc(obj, (zzbmm) obj2);
            }
        }, zzcae.zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(Object obj, zzbmm zzbmmVar) throws Exception {
        zzcaj zzcajVar = new zzcaj();
        com.google.android.gms.ads.internal.zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        zzbii.zzo.zzc(uuid, new zzbnk(this, zzcajVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", uuid);
        jSONObject.put("args", (JSONObject) obj);
        zzbmmVar.zzl(this.zzc, jSONObject);
        return zzcajVar;
    }
}
