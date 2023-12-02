package com.arlosoft.macrodroid.geofences;

import android.location.Location;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes3.dex */
public class LocationHelper {
    public static int metersToEquatorPixels(GoogleMap googleMap, LatLng latLng, float f4) {
        Location location = new Location("");
        location.setLatitude(latLng.latitude);
        location.setLongitude(latLng.longitude);
        Location location2 = new Location("");
        location2.setLatitude(latLng.latitude);
        location2.setLongitude(latLng.longitude + 0.5d);
        double distanceTo = f4 * (0.5d / location.distanceTo(location2));
        Projection projection = googleMap.getProjection();
        return Math.abs(projection.toScreenLocation(new LatLng(latLng.latitude, latLng.longitude + distanceTo)).x - projection.toScreenLocation(latLng).x);
    }
}
