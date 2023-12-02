package com.google.android.gms.location.places;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.maps.model.LatLngBounds;
import javax.annotation.Nullable;

@Deprecated
/* loaded from: classes4.dex */
public interface GeoDataApi {
    @Deprecated
    PendingResult<PlaceBuffer> addPlace(@NonNull GoogleApiClient googleApiClient, @NonNull AddPlaceRequest addPlaceRequest);

    PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(@NonNull GoogleApiClient googleApiClient, @Nullable String str, @Nullable LatLngBounds latLngBounds, @Nullable AutocompleteFilter autocompleteFilter);

    PendingResult<PlaceBuffer> getPlaceById(@NonNull GoogleApiClient googleApiClient, @NonNull String... strArr);

    PendingResult<PlacePhotoMetadataResult> getPlacePhotos(@NonNull GoogleApiClient googleApiClient, @NonNull String str);
}
