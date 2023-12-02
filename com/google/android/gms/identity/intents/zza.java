package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.identity.intents.Address;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
/* loaded from: classes4.dex */
final class zza extends Api.AbstractClientBuilder<com.google.android.gms.internal.identity.zze, Address.AddressOptions> {
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.identity.zze buildClient(Context context, Looper looper, ClientSettings clientSettings, Address.AddressOptions addressOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Address.AddressOptions addressOptions2 = addressOptions;
        Preconditions.checkArgument(context instanceof Activity, "An Activity must be used for Address APIs");
        if (addressOptions2 == null) {
            addressOptions2 = new Address.AddressOptions();
        }
        return new com.google.android.gms.internal.identity.zze((Activity) context, looper, clientSettings, addressOptions2.theme, connectionCallbacks, onConnectionFailedListener);
    }
}
