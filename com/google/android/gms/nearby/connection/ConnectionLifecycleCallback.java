package com.google.android.gms.nearby.connection;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class ConnectionLifecycleCallback {
    public abstract void onConnectionInitiated(@NonNull String str, @NonNull ConnectionInfo connectionInfo);

    public abstract void onConnectionResult(@NonNull String str, @NonNull ConnectionResolution connectionResolution);

    public abstract void onDisconnected(@NonNull String str);

    public void onBandwidthChanged(@NonNull String str, @NonNull BandwidthInfo bandwidthInfo) {
    }
}
