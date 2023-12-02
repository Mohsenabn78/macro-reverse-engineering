package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

/* loaded from: classes4.dex */
public interface IGoogleMapDelegate extends IInterface {
    com.google.android.gms.internal.maps.zzh addCircle(CircleOptions circleOptions) throws RemoteException;

    com.google.android.gms.internal.maps.zzk addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    com.google.android.gms.internal.maps.zzt addMarker(MarkerOptions markerOptions) throws RemoteException;

    com.google.android.gms.internal.maps.zzw addPolygon(PolygonOptions polygonOptions) throws RemoteException;

    com.google.android.gms.internal.maps.zzz addPolyline(PolylineOptions polylineOptions) throws RemoteException;

    com.google.android.gms.internal.maps.zzac addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    void animateCamera(IObjectWrapper iObjectWrapper) throws RemoteException;

    void animateCameraWithCallback(IObjectWrapper iObjectWrapper, zzc zzcVar) throws RemoteException;

    void animateCameraWithDurationAndCallback(IObjectWrapper iObjectWrapper, int i4, zzc zzcVar) throws RemoteException;

    void clear() throws RemoteException;

    CameraPosition getCameraPosition() throws RemoteException;

    com.google.android.gms.internal.maps.zzn getFocusedBuilding() throws RemoteException;

    void getMapAsync(zzap zzapVar) throws RemoteException;

    int getMapType() throws RemoteException;

    float getMaxZoomLevel() throws RemoteException;

    float getMinZoomLevel() throws RemoteException;

    Location getMyLocation() throws RemoteException;

    IProjectionDelegate getProjection() throws RemoteException;

    IUiSettingsDelegate getUiSettings() throws RemoteException;

    boolean isBuildingsEnabled() throws RemoteException;

    boolean isIndoorEnabled() throws RemoteException;

    boolean isMyLocationEnabled() throws RemoteException;

    boolean isTrafficEnabled() throws RemoteException;

    void moveCamera(IObjectWrapper iObjectWrapper) throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onEnterAmbient(Bundle bundle) throws RemoteException;

    void onExitAmbient() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;

    void resetMinMaxZoomPreference() throws RemoteException;

    void setBuildingsEnabled(boolean z3) throws RemoteException;

    void setContentDescription(String str) throws RemoteException;

    boolean setIndoorEnabled(boolean z3) throws RemoteException;

    void setInfoWindowAdapter(zzh zzhVar) throws RemoteException;

    void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) throws RemoteException;

    void setLocationSource(ILocationSourceDelegate iLocationSourceDelegate) throws RemoteException;

    boolean setMapStyle(MapStyleOptions mapStyleOptions) throws RemoteException;

    void setMapType(int i4) throws RemoteException;

    void setMaxZoomPreference(float f4) throws RemoteException;

    void setMinZoomPreference(float f4) throws RemoteException;

    void setMyLocationEnabled(boolean z3) throws RemoteException;

    void setOnCameraChangeListener(zzl zzlVar) throws RemoteException;

    void setOnCameraIdleListener(zzn zznVar) throws RemoteException;

    void setOnCameraMoveCanceledListener(zzp zzpVar) throws RemoteException;

    void setOnCameraMoveListener(zzr zzrVar) throws RemoteException;

    void setOnCameraMoveStartedListener(zzt zztVar) throws RemoteException;

    void setOnCircleClickListener(zzv zzvVar) throws RemoteException;

    void setOnGroundOverlayClickListener(zzx zzxVar) throws RemoteException;

    void setOnIndoorStateChangeListener(zzz zzzVar) throws RemoteException;

    void setOnInfoWindowClickListener(zzab zzabVar) throws RemoteException;

    void setOnInfoWindowCloseListener(zzad zzadVar) throws RemoteException;

    void setOnInfoWindowLongClickListener(zzaf zzafVar) throws RemoteException;

    void setOnMapClickListener(zzaj zzajVar) throws RemoteException;

    void setOnMapLoadedCallback(zzal zzalVar) throws RemoteException;

    void setOnMapLongClickListener(zzan zzanVar) throws RemoteException;

    void setOnMarkerClickListener(zzar zzarVar) throws RemoteException;

    void setOnMarkerDragListener(zzat zzatVar) throws RemoteException;

    void setOnMyLocationButtonClickListener(zzav zzavVar) throws RemoteException;

    void setOnMyLocationChangeListener(zzax zzaxVar) throws RemoteException;

    void setOnMyLocationClickListener(zzaz zzazVar) throws RemoteException;

    void setOnPoiClickListener(zzbb zzbbVar) throws RemoteException;

    void setOnPolygonClickListener(zzbd zzbdVar) throws RemoteException;

    void setOnPolylineClickListener(zzbf zzbfVar) throws RemoteException;

    void setPadding(int i4, int i5, int i6, int i7) throws RemoteException;

    void setTrafficEnabled(boolean z3) throws RemoteException;

    void setWatermarkEnabled(boolean z3) throws RemoteException;

    void snapshot(zzbs zzbsVar, IObjectWrapper iObjectWrapper) throws RemoteException;

    void snapshotForTest(zzbs zzbsVar) throws RemoteException;

    void stopAnimation() throws RemoteException;

    boolean useViewLifecycleWhenInFragment() throws RemoteException;
}
