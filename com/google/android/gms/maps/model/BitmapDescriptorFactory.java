package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;

    /* renamed from: a  reason: collision with root package name */
    private static com.google.android.gms.internal.maps.zze f21283a;

    private BitmapDescriptorFactory() {
    }

    private static com.google.android.gms.internal.maps.zze a() {
        return (com.google.android.gms.internal.maps.zze) Preconditions.checkNotNull(f21283a, "IBitmapDescriptorFactory is not initialized");
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            return new BitmapDescriptor(a().zzi());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            return new BitmapDescriptor(a().zza(str));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        try {
            return new BitmapDescriptor(a().zza(bitmap));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            return new BitmapDescriptor(a().zzb(str));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return new BitmapDescriptor(a().zzc(str));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static BitmapDescriptor fromResource(int i4) {
        try {
            return new BitmapDescriptor(a().zza(i4));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static void zza(com.google.android.gms.internal.maps.zze zzeVar) {
        if (f21283a != null) {
            return;
        }
        f21283a = (com.google.android.gms.internal.maps.zze) Preconditions.checkNotNull(zzeVar);
    }

    public static BitmapDescriptor defaultMarker(float f4) {
        try {
            return new BitmapDescriptor(a().zza(f4));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
