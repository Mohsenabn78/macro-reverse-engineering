package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbqz implements NativeCustomFormatAd.DisplayOpenMeasurement {
    private final zzbfl zza;

    public zzbqz(zzbfl zzbflVar) {
        this.zza = zzbflVar;
        try {
            zzbflVar.zzm();
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd.DisplayOpenMeasurement
    public final void setView(View view) {
        try {
            this.zza.zzp(ObjectWrapper.wrap(view));
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd.DisplayOpenMeasurement
    public final boolean start() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
            return false;
        }
    }
}
