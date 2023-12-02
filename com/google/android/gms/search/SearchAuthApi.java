package com.google.android.gms.search;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public interface SearchAuthApi {

    /* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
    /* loaded from: classes4.dex */
    public interface GoogleNowAuthResult extends Result {
        @NonNull
        GoogleNowAuthState getGoogleNowAuthState();
    }

    @NonNull
    PendingResult<Status> clearToken(@NonNull GoogleApiClient googleApiClient, @NonNull String str);

    @NonNull
    PendingResult<GoogleNowAuthResult> getGoogleNowAuth(@NonNull GoogleApiClient googleApiClient, @NonNull String str);
}
