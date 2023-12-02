package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;

/* loaded from: classes4.dex */
public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;

    /* renamed from: a  reason: collision with root package name */
    private final IGoogleMapDelegate f21199a;

    /* renamed from: b  reason: collision with root package name */
    private UiSettings f21200b;

    /* loaded from: classes4.dex */
    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    /* loaded from: classes4.dex */
    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    /* loaded from: classes4.dex */
    public interface OnCameraIdleListener {
        void onCameraIdle();
    }

    /* loaded from: classes4.dex */
    public interface OnCameraMoveCanceledListener {
        void onCameraMoveCanceled();
    }

    /* loaded from: classes4.dex */
    public interface OnCameraMoveListener {
        void onCameraMove();
    }

    /* loaded from: classes4.dex */
    public interface OnCameraMoveStartedListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onCameraMoveStarted(int i4);
    }

    /* loaded from: classes4.dex */
    public interface OnCircleClickListener {
        void onCircleClick(Circle circle);
    }

    /* loaded from: classes4.dex */
    public interface OnGroundOverlayClickListener {
        void onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    /* loaded from: classes4.dex */
    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    /* loaded from: classes4.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    /* loaded from: classes4.dex */
    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(Marker marker);
    }

    /* loaded from: classes4.dex */
    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(Marker marker);
    }

    /* loaded from: classes4.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    /* loaded from: classes4.dex */
    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    /* loaded from: classes4.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* loaded from: classes4.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* loaded from: classes4.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* loaded from: classes4.dex */
    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    /* loaded from: classes4.dex */
    public interface OnMyLocationClickListener {
        void onMyLocationClick(@NonNull Location location);
    }

    /* loaded from: classes4.dex */
    public interface OnPoiClickListener {
        void onPoiClick(PointOfInterest pointOfInterest);
    }

    /* loaded from: classes4.dex */
    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon);
    }

    /* loaded from: classes4.dex */
    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    /* loaded from: classes4.dex */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* loaded from: classes4.dex */
    private static final class zza extends com.google.android.gms.maps.internal.zzd {

        /* renamed from: a  reason: collision with root package name */
        private final CancelableCallback f21201a;

        zza(CancelableCallback cancelableCallback) {
            this.f21201a = cancelableCallback;
        }

        @Override // com.google.android.gms.maps.internal.zzc
        public final void onCancel() {
            this.f21201a.onCancel();
        }

        @Override // com.google.android.gms.maps.internal.zzc
        public final void onFinish() {
            this.f21201a.onFinish();
        }
    }

    public GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f21199a = (IGoogleMapDelegate) Preconditions.checkNotNull(iGoogleMapDelegate);
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.f21199a.addCircle(circleOptions));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            com.google.android.gms.internal.maps.zzk addGroundOverlay = this.f21199a.addGroundOverlay(groundOverlayOptions);
            if (addGroundOverlay != null) {
                return new GroundOverlay(addGroundOverlay);
            }
            return null;
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            com.google.android.gms.internal.maps.zzt addMarker = this.f21199a.addMarker(markerOptions);
            if (addMarker != null) {
                return new Marker(addMarker);
            }
            return null;
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.f21199a.addPolygon(polygonOptions));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.f21199a.addPolyline(polylineOptions));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            com.google.android.gms.internal.maps.zzac addTileOverlay = this.f21199a.addTileOverlay(tileOverlayOptions);
            if (addTileOverlay != null) {
                return new TileOverlay(addTileOverlay);
            }
            return null;
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.f21199a.animateCamera(cameraUpdate.zzb());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void clear() {
        try {
            this.f21199a.clear();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.f21199a.getCameraPosition();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final IndoorBuilding getFocusedBuilding() {
        try {
            com.google.android.gms.internal.maps.zzn focusedBuilding = this.f21199a.getFocusedBuilding();
            if (focusedBuilding != null) {
                return new IndoorBuilding(focusedBuilding);
            }
            return null;
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final int getMapType() {
        try {
            return this.f21199a.getMapType();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.f21199a.getMaxZoomLevel();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.f21199a.getMinZoomLevel();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.f21199a.getMyLocation();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.f21199a.getProjection());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.f21200b == null) {
                this.f21200b = new UiSettings(this.f21199a.getUiSettings());
            }
            return this.f21200b;
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.f21199a.isBuildingsEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.f21199a.isIndoorEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.f21199a.isMyLocationEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.f21199a.isTrafficEnabled();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.f21199a.moveCamera(cameraUpdate.zzb());
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void resetMinMaxZoomPreference() {
        try {
            this.f21199a.resetMinMaxZoomPreference();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setBuildingsEnabled(boolean z3) {
        try {
            this.f21199a.setBuildingsEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setContentDescription(String str) {
        try {
            this.f21199a.setContentDescription(str);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean setIndoorEnabled(boolean z3) {
        try {
            return this.f21199a.setIndoorEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        try {
            if (infoWindowAdapter == null) {
                this.f21199a.setInfoWindowAdapter(null);
            } else {
                this.f21199a.setInfoWindowAdapter(new zzg(this, infoWindowAdapter));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        try {
            this.f21199a.setLatLngBoundsForCameraTarget(latLngBounds);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        try {
            if (locationSource == null) {
                this.f21199a.setLocationSource(null);
            } else {
                this.f21199a.setLocationSource(new zzl(this, locationSource));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final boolean setMapStyle(@Nullable MapStyleOptions mapStyleOptions) {
        try {
            return this.f21199a.setMapStyle(mapStyleOptions);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setMapType(int i4) {
        try {
            this.f21199a.setMapType(i4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setMaxZoomPreference(float f4) {
        try {
            this.f21199a.setMaxZoomPreference(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setMinZoomPreference(float f4) {
        try {
            this.f21199a.setMinZoomPreference(f4);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public final void setMyLocationEnabled(boolean z3) {
        try {
            this.f21199a.setMyLocationEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @Deprecated
    public final void setOnCameraChangeListener(@Nullable OnCameraChangeListener onCameraChangeListener) {
        try {
            if (onCameraChangeListener == null) {
                this.f21199a.setOnCameraChangeListener(null);
            } else {
                this.f21199a.setOnCameraChangeListener(new zzt(this, onCameraChangeListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnCameraIdleListener(@Nullable OnCameraIdleListener onCameraIdleListener) {
        try {
            if (onCameraIdleListener == null) {
                this.f21199a.setOnCameraIdleListener(null);
            } else {
                this.f21199a.setOnCameraIdleListener(new zzx(this, onCameraIdleListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnCameraMoveCanceledListener(@Nullable OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        try {
            if (onCameraMoveCanceledListener == null) {
                this.f21199a.setOnCameraMoveCanceledListener(null);
            } else {
                this.f21199a.setOnCameraMoveCanceledListener(new zzw(this, onCameraMoveCanceledListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnCameraMoveListener(@Nullable OnCameraMoveListener onCameraMoveListener) {
        try {
            if (onCameraMoveListener == null) {
                this.f21199a.setOnCameraMoveListener(null);
            } else {
                this.f21199a.setOnCameraMoveListener(new zzv(this, onCameraMoveListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnCameraMoveStartedListener(@Nullable OnCameraMoveStartedListener onCameraMoveStartedListener) {
        try {
            if (onCameraMoveStartedListener == null) {
                this.f21199a.setOnCameraMoveStartedListener(null);
            } else {
                this.f21199a.setOnCameraMoveStartedListener(new zzu(this, onCameraMoveStartedListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        try {
            if (onCircleClickListener == null) {
                this.f21199a.setOnCircleClickListener(null);
            } else {
                this.f21199a.setOnCircleClickListener(new zzo(this, onCircleClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        try {
            if (onGroundOverlayClickListener == null) {
                this.f21199a.setOnGroundOverlayClickListener(null);
            } else {
                this.f21199a.setOnGroundOverlayClickListener(new zzn(this, onGroundOverlayClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onIndoorStateChangeListener) {
        try {
            if (onIndoorStateChangeListener == null) {
                this.f21199a.setOnIndoorStateChangeListener(null);
            } else {
                this.f21199a.setOnIndoorStateChangeListener(new com.google.android.gms.maps.zza(this, onIndoorStateChangeListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnInfoWindowClickListener(@Nullable OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            if (onInfoWindowClickListener == null) {
                this.f21199a.setOnInfoWindowClickListener(null);
            } else {
                this.f21199a.setOnInfoWindowClickListener(new zzd(this, onInfoWindowClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnInfoWindowCloseListener(@Nullable OnInfoWindowCloseListener onInfoWindowCloseListener) {
        try {
            if (onInfoWindowCloseListener == null) {
                this.f21199a.setOnInfoWindowCloseListener(null);
            } else {
                this.f21199a.setOnInfoWindowCloseListener(new zzf(this, onInfoWindowCloseListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnInfoWindowLongClickListener(@Nullable OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        try {
            if (onInfoWindowLongClickListener == null) {
                this.f21199a.setOnInfoWindowLongClickListener(null);
            } else {
                this.f21199a.setOnInfoWindowLongClickListener(new zze(this, onInfoWindowLongClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnMapClickListener(@Nullable OnMapClickListener onMapClickListener) {
        try {
            if (onMapClickListener == null) {
                this.f21199a.setOnMapClickListener(null);
            } else {
                this.f21199a.setOnMapClickListener(new zzy(this, onMapClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        try {
            if (onMapLoadedCallback == null) {
                this.f21199a.setOnMapLoadedCallback(null);
            } else {
                this.f21199a.setOnMapLoadedCallback(new zzk(this, onMapLoadedCallback));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnMapLongClickListener(@Nullable OnMapLongClickListener onMapLongClickListener) {
        try {
            if (onMapLongClickListener == null) {
                this.f21199a.setOnMapLongClickListener(null);
            } else {
                this.f21199a.setOnMapLongClickListener(new zzz(this, onMapLongClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnMarkerClickListener(@Nullable OnMarkerClickListener onMarkerClickListener) {
        try {
            if (onMarkerClickListener == null) {
                this.f21199a.setOnMarkerClickListener(null);
            } else {
                this.f21199a.setOnMarkerClickListener(new zzb(this, onMarkerClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnMarkerDragListener(@Nullable OnMarkerDragListener onMarkerDragListener) {
        try {
            if (onMarkerDragListener == null) {
                this.f21199a.setOnMarkerDragListener(null);
            } else {
                this.f21199a.setOnMarkerDragListener(new zzc(this, onMarkerDragListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnMyLocationButtonClickListener(@Nullable OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        try {
            if (onMyLocationButtonClickListener == null) {
                this.f21199a.setOnMyLocationButtonClickListener(null);
            } else {
                this.f21199a.setOnMyLocationButtonClickListener(new zzi(this, onMyLocationButtonClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(@Nullable OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            if (onMyLocationChangeListener == null) {
                this.f21199a.setOnMyLocationChangeListener(null);
            } else {
                this.f21199a.setOnMyLocationChangeListener(new zzh(this, onMyLocationChangeListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnMyLocationClickListener(@Nullable OnMyLocationClickListener onMyLocationClickListener) {
        try {
            if (onMyLocationClickListener == null) {
                this.f21199a.setOnMyLocationClickListener(null);
            } else {
                this.f21199a.setOnMyLocationClickListener(new zzj(this, onMyLocationClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnPoiClickListener(OnPoiClickListener onPoiClickListener) {
        try {
            if (onPoiClickListener == null) {
                this.f21199a.setOnPoiClickListener(null);
            } else {
                this.f21199a.setOnPoiClickListener(new zzs(this, onPoiClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        try {
            if (onPolygonClickListener == null) {
                this.f21199a.setOnPolygonClickListener(null);
            } else {
                this.f21199a.setOnPolygonClickListener(new zzp(this, onPolygonClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            if (onPolylineClickListener == null) {
                this.f21199a.setOnPolylineClickListener(null);
            } else {
                this.f21199a.setOnPolylineClickListener(new zzq(this, onPolylineClickListener));
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setPadding(int i4, int i5, int i6, int i7) {
        try {
            this.f21199a.setPadding(i4, i5, i6, i7);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void setTrafficEnabled(boolean z3) {
        try {
            this.f21199a.setTrafficEnabled(z3);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        snapshot(snapshotReadyCallback, null);
    }

    public final void stopAnimation() {
        try {
            this.f21199a.stopAnimation();
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        try {
            this.f21199a.snapshot(new zzr(this, snapshotReadyCallback), (ObjectWrapper) (bitmap != null ? ObjectWrapper.wrap(bitmap) : null));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.f21199a.animateCameraWithCallback(cameraUpdate.zzb(), cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i4, CancelableCallback cancelableCallback) {
        try {
            this.f21199a.animateCameraWithDurationAndCallback(cameraUpdate.zzb(), i4, cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
