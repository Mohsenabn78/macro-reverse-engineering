package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdks {
    private final Executor zza;
    private final zzcoh zzb;
    private final zzdco zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdks(Executor executor, zzcoh zzcohVar, zzdco zzdcoVar) {
        this.zza = executor;
        this.zzc = zzdcoVar;
        this.zzb = zzcohVar;
    }

    public final void zza(final zzcez zzcezVar) {
        if (zzcezVar == null) {
            return;
        }
        this.zzc.zza(zzcezVar.zzF());
        this.zzc.zzm(new zzaua() { // from class: com.google.android.gms.internal.ads.zzdko
            @Override // com.google.android.gms.internal.ads.zzaua
            public final void zzc(zzatz zzatzVar) {
                zzcgm zzN = zzcez.this.zzN();
                Rect rect = zzatzVar.zzd;
                zzN.zzp(rect.left, rect.top, false);
            }
        }, this.zza);
        this.zzc.zzm(new zzaua() { // from class: com.google.android.gms.internal.ads.zzdkp
            @Override // com.google.android.gms.internal.ads.zzaua
            public final void zzc(zzatz zzatzVar) {
                String str;
                zzcez zzcezVar2 = zzcez.this;
                HashMap hashMap = new HashMap();
                if (true != zzatzVar.zzj) {
                    str = "0";
                } else {
                    str = "1";
                }
                hashMap.put("isVisible", str);
                zzcezVar2.zzd("onAdVisibilityChanged", hashMap);
            }
        }, this.zza);
        this.zzc.zzm(this.zzb, this.zza);
        this.zzb.zzf(zzcezVar);
        zzcezVar.zzad("/trackActiveViewUnit", new zzbij() { // from class: com.google.android.gms.internal.ads.zzdkq
            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zza(Object obj, Map map) {
                zzdks.this.zzb((zzcez) obj, map);
            }
        });
        zzcezVar.zzad("/untrackActiveViewUnit", new zzbij() { // from class: com.google.android.gms.internal.ads.zzdkr
            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zza(Object obj, Map map) {
                zzdks.this.zzc((zzcez) obj, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcez zzcezVar, Map map) {
        this.zzb.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzcez zzcezVar, Map map) {
        this.zzb.zza();
    }
}
