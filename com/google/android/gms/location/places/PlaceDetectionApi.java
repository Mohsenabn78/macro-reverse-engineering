package com.google.android.gms.location.places;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

@Deprecated
/* loaded from: classes4.dex */
public interface PlaceDetectionApi {
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(@NonNull GoogleApiClient googleApiClient, @Nullable PlaceFilter placeFilter);

    PendingResult<Status> reportDeviceAtPlace(@NonNull GoogleApiClient googleApiClient, @NonNull PlaceReport placeReport);
}
