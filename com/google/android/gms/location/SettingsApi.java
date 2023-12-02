package com.google.android.gms.location;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@Deprecated
/* loaded from: classes4.dex */
public interface SettingsApi {
    @NonNull
    PendingResult<LocationSettingsResult> checkLocationSettings(@NonNull GoogleApiClient googleApiClient, @NonNull LocationSettingsRequest locationSettingsRequest);
}
