package com.google.android.gms.location.places.internal;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes4.dex */
public final class zzh implements GeoDataApi {
    @Override // com.google.android.gms.location.places.GeoDataApi
    public final PendingResult<PlaceBuffer> addPlace(@NonNull GoogleApiClient googleApiClient, @NonNull AddPlaceRequest addPlaceRequest) {
        Preconditions.checkNotNull(addPlaceRequest, "userAddedPlace == null");
        return googleApiClient.execute(new zzk(this, Places.GEO_DATA_API, googleApiClient, addPlaceRequest));
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public final PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(@NonNull GoogleApiClient googleApiClient, @Nullable String str, @Nullable LatLngBounds latLngBounds, @Nullable AutocompleteFilter autocompleteFilter) {
        return googleApiClient.enqueue(new zzn(this, Places.GEO_DATA_API, googleApiClient, str, latLngBounds, autocompleteFilter));
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public final PendingResult<PlaceBuffer> getPlaceById(@NonNull GoogleApiClient googleApiClient, @NonNull String... strArr) {
        boolean z3;
        boolean z4;
        boolean z5;
        if (strArr != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "placeIds == null");
        if (strArr.length > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "placeIds is empty");
        for (String str : strArr) {
            if (str != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "placeId == null");
            Preconditions.checkArgument(!str.isEmpty(), "placeId is empty");
        }
        return googleApiClient.enqueue(new zzl(this, Places.GEO_DATA_API, googleApiClient, strArr));
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public final PendingResult<PlacePhotoMetadataResult> getPlacePhotos(@NonNull GoogleApiClient googleApiClient, @NonNull String str) {
        Preconditions.checkNotNull(str, "placeId == null");
        Preconditions.checkArgument(!str.isEmpty(), "placeId is empty");
        return googleApiClient.enqueue(new zzj(this, Places.GEO_DATA_API, googleApiClient, str));
    }

    public final PendingResult<AutocompletePredictionBuffer> zzb(GoogleApiClient googleApiClient, @Nullable String str, @Nullable LatLngBounds latLngBounds, int i4, @Nullable AutocompleteFilter autocompleteFilter) {
        return googleApiClient.enqueue(new zzo(this, Places.GEO_DATA_API, googleApiClient, str, latLngBounds, i4, autocompleteFilter));
    }

    public final PendingResult<PlacePhotoResult> zzb(@NonNull GoogleApiClient googleApiClient, @NonNull PlacePhotoMetadata placePhotoMetadata, @IntRange(from = 1) int i4, @IntRange(from = 1) int i5) {
        Preconditions.checkNotNull(placePhotoMetadata, "photo == null");
        Preconditions.checkArgument(i4 > 0, "width <= 0");
        Preconditions.checkArgument(i5 > 0, "height <= 0");
        zzap zzapVar = (zzap) placePhotoMetadata.freeze();
        String zzk = zzapVar.zzk();
        int index = zzapVar.getIndex();
        Preconditions.checkNotNull(zzk, "fifeUrl == null");
        return googleApiClient.enqueue(new zzm(this, Places.GEO_DATA_API, googleApiClient, zzk, i4, i5, index));
    }
}
