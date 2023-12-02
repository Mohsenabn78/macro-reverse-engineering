package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbrq extends RemoteCreator {
    public zzbrq() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzbrw) {
            return (zzbrw) queryLocalInterface;
        }
        return new zzbru(iBinder);
    }

    @Nullable
    public final zzbrt zza(Activity activity) {
        zzbrt zzbrrVar;
        try {
            IBinder zze = ((zzbrw) getRemoteCreatorInstance(activity)).zze(ObjectWrapper.wrap(activity));
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzbrt) {
                zzbrrVar = (zzbrt) queryLocalInterface;
            } else {
                zzbrrVar = new zzbrr(zze);
            }
            return zzbrrVar;
        } catch (RemoteException e4) {
            zzbzr.zzk("Could not create remote AdOverlay.", e4);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e5) {
            zzbzr.zzk("Could not create remote AdOverlay.", e5);
            return null;
        }
    }
}
