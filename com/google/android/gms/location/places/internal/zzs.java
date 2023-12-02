package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.location.places.PlacesOptions;

/* loaded from: classes4.dex */
public final class zzs extends Api.AbstractClientBuilder<zzq, PlacesOptions> {
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ zzq buildClient(Context context, Looper looper, ClientSettings clientSettings, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        PlacesOptions placesOptions2 = placesOptions;
        if (placesOptions2 == null) {
            placesOptions2 = new PlacesOptions.Builder().build();
        }
        return new zzq(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener, context.getPackageName(), placesOptions2);
    }
}
