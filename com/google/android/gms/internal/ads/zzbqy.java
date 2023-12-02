package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbqy extends NativeAd.AdChoicesInfo {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbqy(zzbej zzbejVar) {
        zzber zzberVar;
        try {
            this.zzb = zzbejVar.zzg();
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
            this.zzb = "";
        }
        try {
            for (Object obj : zzbejVar.zzh()) {
                if (obj instanceof IBinder) {
                    zzberVar = zzbeq.zzg((IBinder) obj);
                } else {
                    zzberVar = null;
                }
                if (zzberVar != null) {
                    this.zza.add(new zzbra(zzberVar));
                }
            }
        } catch (RemoteException e5) {
            zzbzr.zzh("", e5);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.zzb;
    }
}
