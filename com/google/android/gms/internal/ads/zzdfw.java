package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzdfw implements zzbij {
    private final WeakReference zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdfw(zzdfx zzdfxVar, zzdfv zzdfvVar) {
        this.zza = new WeakReference(zzdfxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zza(Object obj, Map map) {
        zzdfx zzdfxVar = (zzdfx) this.zza.get();
        if (zzdfxVar == null) {
            return;
        }
        zzdfx.zzc(zzdfxVar).zza();
    }
}
