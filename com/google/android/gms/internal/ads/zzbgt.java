package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbgt extends zzbfu {
    final /* synthetic */ zzbgw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbgt(zzbgw zzbgwVar, zzbgs zzbgsVar) {
        this.zza = zzbgwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfv
    public final void zze(zzbfl zzbflVar, String str) {
        zzbgw zzbgwVar = this.zza;
        if (zzbgw.zza(zzbgwVar) == null) {
            return;
        }
        zzbgw.zza(zzbgwVar).onCustomClick(zzbgw.zzc(zzbgwVar, zzbflVar), str);
    }
}
