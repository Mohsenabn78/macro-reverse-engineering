package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbdy {
    private final Context zza;

    public zzbdy(Context context) {
        this.zza = context;
    }

    public final void zza(zzbtd zzbtdVar) {
        try {
            ((zzbdz) zzbzv.zzb(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", new zzbzt() { // from class: com.google.android.gms.internal.ads.zzbdx
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzbzt
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface queryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
                    if (queryLocalInterface instanceof zzbdz) {
                        return (zzbdz) queryLocalInterface;
                    }
                    return new zzbdz(obj);
                }
            })).zze(zzbtdVar);
        } catch (RemoteException e4) {
            zzbzr.zzj("Error calling setFlagsAccessedBeforeInitializedListener: ".concat(String.valueOf(e4.getMessage())));
        } catch (zzbzu e5) {
            zzbzr.zzj("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(e5.getMessage())));
        }
    }
}
