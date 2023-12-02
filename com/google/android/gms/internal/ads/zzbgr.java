package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbgr extends RemoteCreator {
    @VisibleForTesting
    public zzbgr() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (queryLocalInterface instanceof zzbfe) {
            return (zzbfe) queryLocalInterface;
        }
        return new zzbfc(iBinder);
    }

    @Nullable
    public final zzbfb zza(View view, HashMap hashMap, HashMap hashMap2) {
        zzbfb zzbezVar;
        try {
            IBinder zze = ((zzbfe) getRemoteCreatorInstance(view.getContext())).zze(ObjectWrapper.wrap(view), ObjectWrapper.wrap(hashMap), ObjectWrapper.wrap(hashMap2));
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            if (queryLocalInterface instanceof zzbfb) {
                zzbezVar = (zzbfb) queryLocalInterface;
            } else {
                zzbezVar = new zzbez(zze);
            }
            return zzbezVar;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e4) {
            zzbzr.zzk("Could not create remote NativeAdViewHolderDelegate.", e4);
            return null;
        }
    }
}
