package com.google.android.gms.location.places.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;

/* loaded from: classes4.dex */
public final class zzz implements PlaceDetectionApi {
    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public final PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(@NonNull GoogleApiClient googleApiClient, @Nullable PlaceFilter placeFilter) {
        return googleApiClient.enqueue(new zzac(this, Places.PLACE_DETECTION_API, googleApiClient, placeFilter));
    }

    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public final PendingResult<Status> reportDeviceAtPlace(@NonNull GoogleApiClient googleApiClient, @NonNull PlaceReport placeReport) {
        Preconditions.checkNotNull(placeReport, "report == null");
        return googleApiClient.execute(new zzab(this, Places.PLACE_DETECTION_API, googleApiClient, placeReport));
    }
}
