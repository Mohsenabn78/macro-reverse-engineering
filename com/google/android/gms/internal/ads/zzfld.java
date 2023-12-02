package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfld {
    @VisibleForTesting
    final zzflg zza;
    @VisibleForTesting
    final boolean zzb;

    private zzfld(zzflg zzflgVar) {
        boolean z3;
        this.zza = zzflgVar;
        if (zzflgVar != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzb = z3;
    }

    public static zzfld zzb(Context context, String str, String str2) {
        zzflg zzfleVar;
        try {
            try {
                try {
                    IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (instantiate == null) {
                        zzfleVar = null;
                    } else {
                        IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        if (queryLocalInterface instanceof zzflg) {
                            zzfleVar = (zzflg) queryLocalInterface;
                        } else {
                            zzfleVar = new zzfle(instantiate);
                        }
                    }
                    zzfleVar.zze(ObjectWrapper.wrap(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzfld(zzfleVar);
                } catch (RemoteException | zzfkf | NullPointerException | SecurityException unused) {
                    return new zzfld(new zzflh());
                }
            } catch (Exception e4) {
                throw new zzfkf(e4);
            }
        } catch (Exception e5) {
            throw new zzfkf(e5);
        }
    }

    public static zzfld zzc() {
        return new zzfld(new zzflh());
    }

    public final zzflc zza(byte[] bArr) {
        return new zzflc(this, bArr, null);
    }
}
