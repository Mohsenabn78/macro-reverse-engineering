package com.google.android.gms.nearby.connection;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class EndpointDiscoveryCallback {
    public abstract void onEndpointFound(@NonNull String str, @NonNull DiscoveredEndpointInfo discoveredEndpointInfo);

    public abstract void onEndpointLost(@NonNull String str);
}
