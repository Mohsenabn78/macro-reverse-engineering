package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbgq extends RemoteCreator {
    @VisibleForTesting
    public zzbgq() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (queryLocalInterface instanceof zzbey) {
            return (zzbey) queryLocalInterface;
        }
        return new zzbew(iBinder);
    }

    @Nullable
    public final zzbev zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        zzbev zzbetVar;
        try {
            IBinder zze = ((zzbey) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(frameLayout), ObjectWrapper.wrap(frameLayout2), ModuleDescriptor.MODULE_VERSION);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface instanceof zzbev) {
                zzbetVar = (zzbev) queryLocalInterface;
            } else {
                zzbetVar = new zzbet(zze);
            }
            return zzbetVar;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e4) {
            zzbzr.zzk("Could not create remote NativeAdViewDelegate.", e4);
            return null;
        }
    }
}
