package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbso extends zzbsh {
    final /* synthetic */ List zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbso(zzbsq zzbsqVar, List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.internal.ads.zzbsi
    public final void zze(String str) {
        zzbzr.zzg("Error recording click: ".concat(String.valueOf(str)));
    }

    @Override // com.google.android.gms.internal.ads.zzbsi
    public final void zzf(List list) {
        zzbzr.zzi("Recorded click: ".concat(this.zza.toString()));
    }
}
