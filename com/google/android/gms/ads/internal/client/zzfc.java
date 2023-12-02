package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzbvu;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzbwb;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfc extends zzbvm {
    private static void a(final zzbvu zzbvuVar) {
        zzbzr.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbzk.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzfb
            @Override // java.lang.Runnable
            public final void run() {
                zzbvu zzbvuVar2 = zzbvu.this;
                if (zzbvuVar2 != null) {
                    try {
                        zzbvuVar2.zze(1);
                    } catch (RemoteException e4) {
                        zzbzr.zzl("#007 Could not call remote method.", e4);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final Bundle zzb() throws RemoteException {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final zzdn zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    @Nullable
    public final zzbvk zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final String zze() throws RemoteException {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzf(zzl zzlVar, zzbvu zzbvuVar) throws RemoteException {
        a(zzbvuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzg(zzl zzlVar, zzbvu zzbvuVar) throws RemoteException {
        a(zzbvuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final boolean zzo() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzh(boolean z3) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzi(zzdd zzddVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzj(zzdg zzdgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzk(zzbvq zzbvqVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzl(zzbwb zzbwbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzp(zzbvv zzbvvVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzn(IObjectWrapper iObjectWrapper, boolean z3) {
    }
}
