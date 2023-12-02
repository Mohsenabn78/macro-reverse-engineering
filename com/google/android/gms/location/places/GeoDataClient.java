package com.google.android.gms.location.places;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.tasks.Task;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
/* loaded from: classes4.dex */
public class GeoDataClient extends GoogleApi<PlacesOptions> {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface BoundsMode {
        public static final int BIAS = 1;
        public static final int STRICT = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoDataClient(@NonNull Context context, @NonNull PlacesOptions placesOptions) {
        super(context, Places.GEO_DATA_API, placesOptions, new ApiExceptionMapper());
    }

    @Deprecated
    public Task<PlaceBufferResponse> addPlace(@NonNull AddPlaceRequest addPlaceRequest) {
        return PendingResultUtil.toResponseTask(Places.GeoDataApi.addPlace(asGoogleApiClient(), addPlaceRequest), new PlaceBufferResponse());
    }

    public Task<AutocompletePredictionBufferResponse> getAutocompletePredictions(@Nullable String str, @Nullable LatLngBounds latLngBounds, int i4, @Nullable AutocompleteFilter autocompleteFilter) {
        return PendingResultUtil.toResponseTask(((com.google.android.gms.location.places.internal.zzh) Places.GeoDataApi).zzb(asGoogleApiClient(), str, latLngBounds, i4, autocompleteFilter), new AutocompletePredictionBufferResponse());
    }

    public Task<PlacePhotoResponse> getPhoto(@NonNull PlacePhotoMetadata placePhotoMetadata) {
        return getScaledPhoto(placePhotoMetadata, placePhotoMetadata.getMaxWidth(), placePhotoMetadata.getMaxHeight());
    }

    public Task<PlaceBufferResponse> getPlaceById(@NonNull String... strArr) {
        return PendingResultUtil.toResponseTask(Places.GeoDataApi.getPlaceById(asGoogleApiClient(), strArr), new PlaceBufferResponse());
    }

    public Task<PlacePhotoMetadataResponse> getPlacePhotos(@NonNull String str) {
        return PendingResultUtil.toResponseTask(Places.GeoDataApi.getPlacePhotos(asGoogleApiClient(), str), new PlacePhotoMetadataResponse());
    }

    public Task<PlacePhotoResponse> getScaledPhoto(@NonNull PlacePhotoMetadata placePhotoMetadata, @IntRange(from = 1) int i4, @IntRange(from = 1) int i5) {
        return PendingResultUtil.toResponseTask(((com.google.android.gms.location.places.internal.zzh) Places.GeoDataApi).zzb(asGoogleApiClient(), placePhotoMetadata, i4, i5), new PlacePhotoResponse());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoDataClient(@NonNull Activity activity, @NonNull PlacesOptions placesOptions) {
        super(activity, Places.GEO_DATA_API, placesOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public Task<AutocompletePredictionBufferResponse> getAutocompletePredictions(@Nullable String str, @Nullable LatLngBounds latLngBounds, @Nullable AutocompleteFilter autocompleteFilter) {
        return getAutocompletePredictions(str, latLngBounds, 1, autocompleteFilter);
    }
}
