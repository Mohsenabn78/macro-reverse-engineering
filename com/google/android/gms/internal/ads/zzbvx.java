package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbvx implements RewardItem {
    private final zzbvk zza;

    public zzbvx(zzbvk zzbvkVar) {
        this.zza = zzbvkVar;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final int getAmount() {
        zzbvk zzbvkVar = this.zza;
        if (zzbvkVar != null) {
            try {
                return zzbvkVar.zze();
            } catch (RemoteException e4) {
                zzbzr.zzk("Could not forward getAmount to RewardItem", e4);
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    @Nullable
    public final String getType() {
        zzbvk zzbvkVar = this.zza;
        if (zzbvkVar != null) {
            try {
                return zzbvkVar.zzf();
            } catch (RemoteException e4) {
                zzbzr.zzk("Could not forward getType to RewardItem", e4);
            }
        }
        return null;
    }
}
