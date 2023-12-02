package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzejx {
    private final zzekc zza;
    private final String zzb;
    @Nullable
    private com.google.android.gms.ads.internal.client.zzdn zzc;

    public zzejx(zzekc zzekcVar, String str) {
        this.zza = zzekcVar;
        this.zzb = str;
    }

    @Nullable
    public final synchronized String zza() {
        String str;
        str = null;
        try {
            com.google.android.gms.ads.internal.client.zzdn zzdnVar = this.zzc;
            if (zzdnVar != null) {
                str = zzdnVar.zzg();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            return null;
        }
        return str;
    }

    @Nullable
    public final synchronized String zzb() {
        String str;
        str = null;
        try {
            com.google.android.gms.ads.internal.client.zzdn zzdnVar = this.zzc;
            if (zzdnVar != null) {
                str = zzdnVar.zzg();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            return null;
        }
        return str;
    }

    public final synchronized void zzd(com.google.android.gms.ads.internal.client.zzl zzlVar, int i4) throws RemoteException {
        this.zzc = null;
        this.zza.zzb(zzlVar, this.zzb, new zzekd(i4), new zzejw(this));
    }

    public final synchronized boolean zze() throws RemoteException {
        return this.zza.zza();
    }
}
