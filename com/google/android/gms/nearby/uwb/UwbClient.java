package com.google.android.gms.nearby.uwb;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public interface UwbClient extends HasApiKey<zze> {
    @NonNull
    Task<Void> addControlee(@NonNull UwbAddress uwbAddress);

    @NonNull
    Task<UwbComplexChannel> getComplexChannel();

    @NonNull
    Task<UwbAddress> getLocalAddress();

    @NonNull
    Task<RangingCapabilities> getRangingCapabilities();

    @NonNull
    Task<Boolean> isAvailable();

    @NonNull
    Task<Void> removeControlee(@NonNull UwbAddress uwbAddress);

    @NonNull
    Task<Void> startRanging(@NonNull RangingParameters rangingParameters, @NonNull RangingSessionCallback rangingSessionCallback);

    @NonNull
    Task<Void> stopRanging(@NonNull RangingSessionCallback rangingSessionCallback);
}
