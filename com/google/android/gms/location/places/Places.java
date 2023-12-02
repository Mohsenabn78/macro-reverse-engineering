package com.google.android.gms.location.places;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.internal.zzae;
import com.google.android.gms.location.places.internal.zzaf;
import com.google.android.gms.location.places.internal.zzq;
import com.google.android.gms.location.places.internal.zzs;
import com.google.android.gms.location.places.internal.zzz;

@Deprecated
/* loaded from: classes4.dex */
public class Places {
    public static final Api<PlacesOptions> GEO_DATA_API;
    @Deprecated
    public static final GeoDataApi GeoDataApi;
    public static final Api<PlacesOptions> PLACE_DETECTION_API;
    @Deprecated
    public static final PlaceDetectionApi PlaceDetectionApi;

    /* renamed from: a  reason: collision with root package name */
    private static final Api.ClientKey<zzq> f21048a;

    /* renamed from: b  reason: collision with root package name */
    private static final Api.ClientKey<zzae> f21049b;

    static {
        Api.ClientKey<zzq> clientKey = new Api.ClientKey<>();
        f21048a = clientKey;
        Api.ClientKey<zzae> clientKey2 = new Api.ClientKey<>();
        f21049b = clientKey2;
        GEO_DATA_API = new Api<>("Places.GEO_DATA_API", new zzs(), clientKey);
        PLACE_DETECTION_API = new Api<>("Places.PLACE_DETECTION_API", new zzaf(), clientKey2);
        GeoDataApi = new com.google.android.gms.location.places.internal.zzh();
        PlaceDetectionApi = new zzz();
    }

    private Places() {
    }

    @Deprecated
    public static GeoDataClient getGeoDataClient(@NonNull Activity activity) {
        return getGeoDataClient(activity, (PlacesOptions) null);
    }

    @Deprecated
    public static PlaceDetectionClient getPlaceDetectionClient(@NonNull Activity activity) {
        return getPlaceDetectionClient(activity, (PlacesOptions) null);
    }

    @Deprecated
    public static GeoDataClient getGeoDataClient(@NonNull Activity activity, @Nullable PlacesOptions placesOptions) {
        if (placesOptions == null) {
            placesOptions = new PlacesOptions.Builder().build();
        }
        return new GeoDataClient(activity, placesOptions);
    }

    @Deprecated
    public static PlaceDetectionClient getPlaceDetectionClient(@NonNull Activity activity, @Nullable PlacesOptions placesOptions) {
        if (placesOptions == null) {
            placesOptions = new PlacesOptions.Builder().build();
        }
        return new PlaceDetectionClient(activity, placesOptions);
    }

    @Deprecated
    public static GeoDataClient getGeoDataClient(@NonNull Context context) {
        return getGeoDataClient(context, (PlacesOptions) null);
    }

    @Deprecated
    public static PlaceDetectionClient getPlaceDetectionClient(@NonNull Context context) {
        return getPlaceDetectionClient(context, (PlacesOptions) null);
    }

    @Deprecated
    public static GeoDataClient getGeoDataClient(@NonNull Context context, @Nullable PlacesOptions placesOptions) {
        if (placesOptions == null) {
            placesOptions = new PlacesOptions.Builder().build();
        }
        return new GeoDataClient(context, placesOptions);
    }

    @Deprecated
    public static PlaceDetectionClient getPlaceDetectionClient(@NonNull Context context, @Nullable PlacesOptions placesOptions) {
        if (placesOptions == null) {
            placesOptions = new PlacesOptions.Builder().build();
        }
        return new PlaceDetectionClient(context, placesOptions);
    }
}
