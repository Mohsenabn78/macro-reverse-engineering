package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

/* loaded from: classes4.dex */
public interface zzh extends IInterface {
    LatLng getCenter() throws RemoteException;

    int getFillColor() throws RemoteException;

    String getId() throws RemoteException;

    double getRadius() throws RemoteException;

    int getStrokeColor() throws RemoteException;

    List<PatternItem> getStrokePattern() throws RemoteException;

    float getStrokeWidth() throws RemoteException;

    float getZIndex() throws RemoteException;

    boolean isClickable() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setCenter(LatLng latLng) throws RemoteException;

    void setClickable(boolean z3) throws RemoteException;

    void setFillColor(int i4) throws RemoteException;

    void setRadius(double d4) throws RemoteException;

    void setStrokeColor(int i4) throws RemoteException;

    void setStrokePattern(List<PatternItem> list) throws RemoteException;

    void setStrokeWidth(float f4) throws RemoteException;

    void setVisible(boolean z3) throws RemoteException;

    void setZIndex(float f4) throws RemoteException;

    boolean zzb(zzh zzhVar) throws RemoteException;

    void zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    int zzj() throws RemoteException;

    IObjectWrapper zzk() throws RemoteException;
}
