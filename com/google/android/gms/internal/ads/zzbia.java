package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbia implements zzbij {
    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcezVar = (zzcez) obj;
        if (zzcezVar.zzJ() != null) {
            zzcezVar.zzJ().zza();
        }
        com.google.android.gms.ads.internal.overlay.zzl zzL = zzcezVar.zzL();
        if (zzL != null) {
            zzL.zzb();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzl zzM = zzcezVar.zzM();
        if (zzM != null) {
            zzM.zzb();
        } else {
            zzbzr.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
