package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

/* loaded from: classes4.dex */
public final class Projection {

    /* renamed from: a  reason: collision with root package name */
    private final IProjectionDelegate f21236a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Projection(IProjectionDelegate iProjectionDelegate) {
        this.f21236a = iProjectionDelegate;
    }

    public final LatLng fromScreenLocation(Point point) {
        try {
            return this.f21236a.fromScreenLocation(ObjectWrapper.wrap(point));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final VisibleRegion getVisibleRegion() {
        try {
            return this.f21236a.getVisibleRegion();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final Point toScreenLocation(LatLng latLng) {
        try {
            return (Point) ObjectWrapper.unwrap(this.f21236a.toScreenLocation(latLng));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
