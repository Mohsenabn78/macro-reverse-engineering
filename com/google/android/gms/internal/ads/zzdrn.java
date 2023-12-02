package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzdrn extends zzbvt {
    final /* synthetic */ zzdrp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdrn(zzdrp zzdrpVar) {
        this.zza = zzdrpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvu
    public final void zze(int i4) throws RemoteException {
        zzdre zzdreVar;
        long j4;
        zzdrp zzdrpVar = this.zza;
        zzdreVar = zzdrpVar.zzb;
        j4 = zzdrpVar.zza;
        zzdreVar.zzm(j4, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzbvu
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdre zzdreVar;
        long j4;
        zzdrp zzdrpVar = this.zza;
        zzdreVar = zzdrpVar.zzb;
        j4 = zzdrpVar.zza;
        zzdreVar.zzm(j4, zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvu
    public final void zzg() throws RemoteException {
        zzdre zzdreVar;
        long j4;
        zzdrp zzdrpVar = this.zza;
        zzdreVar = zzdrpVar.zzb;
        j4 = zzdrpVar.zza;
        zzdreVar.zzp(j4);
    }
}
