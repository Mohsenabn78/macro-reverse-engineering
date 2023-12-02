package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

/* loaded from: classes4.dex */
public interface IStreetViewPanoramaDelegate extends IInterface {
    void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j4) throws RemoteException;

    void enablePanning(boolean z3) throws RemoteException;

    void enableStreetNames(boolean z3) throws RemoteException;

    void enableUserNavigation(boolean z3) throws RemoteException;

    void enableZoom(boolean z3) throws RemoteException;

    StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException;

    StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException;

    boolean isPanningGesturesEnabled() throws RemoteException;

    boolean isStreetNamesEnabled() throws RemoteException;

    boolean isUserNavigationEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    IObjectWrapper orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;

    StreetViewPanoramaOrientation pointToOrientation(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setOnStreetViewPanoramaCameraChangeListener(zzbh zzbhVar) throws RemoteException;

    void setOnStreetViewPanoramaChangeListener(zzbj zzbjVar) throws RemoteException;

    void setOnStreetViewPanoramaClickListener(zzbl zzblVar) throws RemoteException;

    void setOnStreetViewPanoramaLongClickListener(zzbn zzbnVar) throws RemoteException;

    void setPosition(LatLng latLng) throws RemoteException;

    void setPositionWithID(String str) throws RemoteException;

    void setPositionWithRadius(LatLng latLng, int i4) throws RemoteException;

    void setPositionWithRadiusAndSource(LatLng latLng, int i4, StreetViewSource streetViewSource) throws RemoteException;

    void setPositionWithSource(LatLng latLng, StreetViewSource streetViewSource) throws RemoteException;
}
