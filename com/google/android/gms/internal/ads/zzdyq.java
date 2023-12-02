package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzdyq implements zzfvy {
    final /* synthetic */ zzbtx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyq(zzdyr zzdyrVar, zzbtx zzbtxVar) {
        this.zza = zzbtxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        try {
            this.zza.zze(com.google.android.gms.ads.internal.util.zzaz.zzb(th));
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.zze.zzb("Ad service can't call client", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zzf((ParcelFileDescriptor) obj);
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.zze.zzb("Ad service can't call client", e4);
        }
    }
}
