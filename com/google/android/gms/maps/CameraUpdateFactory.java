package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes4.dex */
public final class CameraUpdateFactory {

    /* renamed from: a  reason: collision with root package name */
    private static ICameraUpdateFactoryDelegate f21198a;

    private CameraUpdateFactory() {
    }

    private static ICameraUpdateFactoryDelegate a() {
        return (ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(f21198a, "CameraUpdateFactory is not initialized");
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        try {
            return new CameraUpdate(a().newCameraPosition(cameraPosition));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        try {
            return new CameraUpdate(a().newLatLng(latLng));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i4) {
        try {
            return new CameraUpdate(a().newLatLngBounds(latLngBounds, i4));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f4) {
        try {
            return new CameraUpdate(a().newLatLngZoom(latLng, f4));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static CameraUpdate scrollBy(float f4, float f5) {
        try {
            return new CameraUpdate(a().scrollBy(f4, f5));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static CameraUpdate zoomBy(float f4) {
        try {
            return new CameraUpdate(a().zoomBy(f4));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static CameraUpdate zoomIn() {
        try {
            return new CameraUpdate(a().zoomIn());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static CameraUpdate zoomOut() {
        try {
            return new CameraUpdate(a().zoomOut());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static CameraUpdate zoomTo(float f4) {
        try {
            return new CameraUpdate(a().zoomTo(f4));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static void zza(ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        f21198a = (ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(iCameraUpdateFactoryDelegate);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i4, int i5, int i6) {
        try {
            return new CameraUpdate(a().newLatLngBoundsWithSize(latLngBounds, i4, i5, i6));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static CameraUpdate zoomBy(float f4, Point point) {
        try {
            return new CameraUpdate(a().zoomByWithFocus(f4, point.x, point.y));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
