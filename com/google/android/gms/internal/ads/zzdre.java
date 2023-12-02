package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdre {
    private final zzbjg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdre(zzbjg zzbjgVar) {
        this.zza = zzbjgVar;
    }

    private final void zzs(zzdrd zzdrdVar) throws RemoteException {
        String zza = zzdrd.zza(zzdrdVar);
        zzbzr.zzi("Dispatching AFMA event on publisher webview: ".concat(zza));
        this.zza.zzb(zza);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdrd("initialize", null));
    }

    public final void zzb(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("interstitial", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onAdClicked";
        this.zza.zzb(zzdrd.zza(zzdrdVar));
    }

    public final void zzc(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("interstitial", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onAdClosed";
        zzs(zzdrdVar);
    }

    public final void zzd(long j4, int i4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("interstitial", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onAdFailedToLoad";
        zzdrdVar.zzd = Integer.valueOf(i4);
        zzs(zzdrdVar);
    }

    public final void zze(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("interstitial", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onAdLoaded";
        zzs(zzdrdVar);
    }

    public final void zzf(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("interstitial", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdrdVar);
    }

    public final void zzg(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("interstitial", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onAdOpened";
        zzs(zzdrdVar);
    }

    public final void zzh(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("creation", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "nativeObjectCreated";
        zzs(zzdrdVar);
    }

    public final void zzi(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("creation", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "nativeObjectNotCreated";
        zzs(zzdrdVar);
    }

    public final void zzj(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("rewarded", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onAdClicked";
        zzs(zzdrdVar);
    }

    public final void zzk(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("rewarded", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onRewardedAdClosed";
        zzs(zzdrdVar);
    }

    public final void zzl(long j4, zzbvk zzbvkVar) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("rewarded", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onUserEarnedReward";
        zzdrdVar.zze = zzbvkVar.zzf();
        zzdrdVar.zzf = Integer.valueOf(zzbvkVar.zze());
        zzs(zzdrdVar);
    }

    public final void zzm(long j4, int i4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("rewarded", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onRewardedAdFailedToLoad";
        zzdrdVar.zzd = Integer.valueOf(i4);
        zzs(zzdrdVar);
    }

    public final void zzn(long j4, int i4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("rewarded", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onRewardedAdFailedToShow";
        zzdrdVar.zzd = Integer.valueOf(i4);
        zzs(zzdrdVar);
    }

    public final void zzo(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("rewarded", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onAdImpression";
        zzs(zzdrdVar);
    }

    public final void zzp(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("rewarded", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onRewardedAdLoaded";
        zzs(zzdrdVar);
    }

    public final void zzq(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("rewarded", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdrdVar);
    }

    public final void zzr(long j4) throws RemoteException {
        zzdrd zzdrdVar = new zzdrd("rewarded", null);
        zzdrdVar.zza = Long.valueOf(j4);
        zzdrdVar.zzc = "onRewardedAdOpened";
        zzs(zzdrdVar);
    }
}
