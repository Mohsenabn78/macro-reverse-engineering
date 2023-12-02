package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes4.dex */
public interface zzt extends IInterface {
    float getAlpha() throws RemoteException;

    String getId() throws RemoteException;

    LatLng getPosition() throws RemoteException;

    float getRotation() throws RemoteException;

    String getSnippet() throws RemoteException;

    String getTitle() throws RemoteException;

    float getZIndex() throws RemoteException;

    void hideInfoWindow() throws RemoteException;

    boolean isDraggable() throws RemoteException;

    boolean isFlat() throws RemoteException;

    boolean isInfoWindowShown() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setAlpha(float f4) throws RemoteException;

    void setAnchor(float f4, float f5) throws RemoteException;

    void setDraggable(boolean z3) throws RemoteException;

    void setFlat(boolean z3) throws RemoteException;

    void setInfoWindowAnchor(float f4, float f5) throws RemoteException;

    void setPosition(LatLng latLng) throws RemoteException;

    void setRotation(float f4) throws RemoteException;

    void setSnippet(String str) throws RemoteException;

    void setTitle(String str) throws RemoteException;

    void setVisible(boolean z3) throws RemoteException;

    void setZIndex(float f4) throws RemoteException;

    void showInfoWindow() throws RemoteException;

    void zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzg(IObjectWrapper iObjectWrapper) throws RemoteException;

    int zzj() throws RemoteException;

    boolean zzj(zzt zztVar) throws RemoteException;

    IObjectWrapper zzk() throws RemoteException;
}
