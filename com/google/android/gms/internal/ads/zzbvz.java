package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbvz {
    @Nullable
    public static final zzbvn zza(Context context, String str, zzbnw zzbnwVar) {
        zzbvn zzbvlVar;
        try {
            IBinder zze = ((zzbvr) zzbzv.zzb(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", new zzbzt() { // from class: com.google.android.gms.internal.ads.zzbvy
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzbzt
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface queryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
                    if (queryLocalInterface instanceof zzbvr) {
                        return (zzbvr) queryLocalInterface;
                    }
                    return new zzbvr(obj);
                }
            })).zze(ObjectWrapper.wrap(context), str, zzbnwVar, ModuleDescriptor.MODULE_VERSION);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzbvn) {
                zzbvlVar = (zzbvn) queryLocalInterface;
            } else {
                zzbvlVar = new zzbvl(zze);
            }
            return zzbvlVar;
        } catch (RemoteException | zzbzu e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            return null;
        }
    }
}
