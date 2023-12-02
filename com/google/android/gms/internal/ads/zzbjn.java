package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@RequiresApi(api = 21)
/* loaded from: classes4.dex */
public final class zzbjn {
    private final Context zza;
    private final OnH5AdsEventListener zzb;
    @Nullable
    private zzbjj zzc;

    public zzbjn(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        Preconditions.checkState(true, "Android version must be Lollipop or higher");
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
        zzbbm.zza(context);
    }

    public static final boolean zzc(String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjb)).booleanValue()) {
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.length() > ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjd)).intValue()) {
            zzbzr.zze("H5 GMSG exceeds max length");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!"gmsg".equals(parse.getScheme()) || !"mobileads.google.com".equals(parse.getHost()) || !"/h5ads".equals(parse.getPath())) {
            return false;
        }
        return true;
    }

    private final void zzd() {
        if (this.zzc != null) {
            return;
        }
        this.zzc = com.google.android.gms.ads.internal.client.zzay.zza().zzl(this.zza, new zzbnt(), this.zzb);
    }

    public final void zza() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjb)).booleanValue()) {
            return;
        }
        zzd();
        zzbjj zzbjjVar = this.zzc;
        if (zzbjjVar != null) {
            try {
                zzbjjVar.zze();
            } catch (RemoteException e4) {
                zzbzr.zzl("#007 Could not call remote method.", e4);
            }
        }
    }

    public final boolean zzb(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzbjj zzbjjVar = this.zzc;
        if (zzbjjVar == null) {
            return false;
        }
        try {
            zzbjjVar.zzf(str);
            return true;
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            return true;
        }
    }
}
