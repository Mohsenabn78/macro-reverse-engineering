package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdfu implements zzbij {
    private final WeakReference zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdfu(zzdfx zzdfxVar, zzdft zzdftVar) {
        this.zza = new WeakReference(zzdfxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zza(Object obj, Map map) {
        zzcve zzcveVar;
        zzdcs zzdcsVar;
        zzdcs zzdcsVar2;
        zzdfx zzdfxVar = (zzdfx) this.zza.get();
        if (zzdfxVar != null) {
            zzcveVar = zzdfxVar.zzh;
            zzcveVar.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjs)).booleanValue()) {
                zzdcsVar = zzdfxVar.zzi;
                zzdcsVar.zzr();
                if (!TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                    zzdcsVar2 = zzdfxVar.zzi;
                    zzdcsVar2.zzs();
                }
            }
        }
    }
}
