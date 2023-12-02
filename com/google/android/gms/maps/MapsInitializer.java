package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes4.dex */
public final class MapsInitializer {
    @GuardedBy("MapsInitializer.class")

    /* renamed from: a  reason: collision with root package name */
    private static boolean f21235a = false;

    private MapsInitializer() {
    }

    public static synchronized int initialize(Context context) {
        synchronized (MapsInitializer.class) {
            Preconditions.checkNotNull(context, "Context is null");
            if (f21235a) {
                return 0;
            }
            try {
                com.google.android.gms.maps.internal.zze zza = zzbz.zza(context);
                try {
                    CameraUpdateFactory.zza(zza.zze());
                    BitmapDescriptorFactory.zza(zza.zzf());
                    f21235a = true;
                    return 0;
                } catch (RemoteException e4) {
                    throw new RuntimeRemoteException(e4);
                }
            } catch (GooglePlayServicesNotAvailableException e5) {
                return e5.errorCode;
            }
        }
    }
}
