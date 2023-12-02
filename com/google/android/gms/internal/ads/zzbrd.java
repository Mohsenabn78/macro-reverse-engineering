package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbrd extends zzbfu {
    final /* synthetic */ zzbrg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbrd(zzbrg zzbrgVar, zzbrc zzbrcVar) {
        this.zza = zzbrgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfv
    public final void zze(zzbfl zzbflVar, String str) {
        zzbrg zzbrgVar = this.zza;
        if (zzbrg.zzc(zzbrgVar) == null) {
            return;
        }
        zzbrg.zzc(zzbrgVar).onCustomClick(zzbrg.zze(zzbrgVar, zzbflVar), str);
    }
}
