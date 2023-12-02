package com.google.android.gms.nearby.connection;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public interface ConnectionsClient extends HasApiKey<ConnectionsOptions> {
    public static final int MAX_BYTES_DATA_SIZE = 1047552;

    @NonNull
    Task<Void> acceptConnection(@NonNull String str, @NonNull PayloadCallback payloadCallback);

    @NonNull
    Task<Void> cancelPayload(@IntRange long j4);

    void disconnectFromEndpoint(@NonNull String str);

    @NonNull
    Task<Void> rejectConnection(@NonNull String str);

    @NonNull
    Task<Void> requestConnection(@NonNull String str, @NonNull String str2, @NonNull ConnectionLifecycleCallback connectionLifecycleCallback);

    @NonNull
    Task<Void> requestConnection(@NonNull String str, @NonNull String str2, @NonNull ConnectionLifecycleCallback connectionLifecycleCallback, @NonNull ConnectionOptions connectionOptions);

    @NonNull
    Task<Void> requestConnection(@NonNull byte[] bArr, @NonNull String str, @NonNull ConnectionLifecycleCallback connectionLifecycleCallback);

    @NonNull
    Task<Void> requestConnection(@NonNull byte[] bArr, @NonNull String str, @NonNull ConnectionLifecycleCallback connectionLifecycleCallback, @NonNull ConnectionOptions connectionOptions);

    @NonNull
    Task<Void> sendPayload(@NonNull String str, @NonNull Payload payload);

    @NonNull
    Task<Void> sendPayload(@NonNull List<String> list, @NonNull Payload payload);

    @NonNull
    Task<Void> startAdvertising(@NonNull String str, @NonNull String str2, @NonNull ConnectionLifecycleCallback connectionLifecycleCallback, @NonNull AdvertisingOptions advertisingOptions);

    @NonNull
    Task<Void> startAdvertising(@NonNull byte[] bArr, @NonNull String str, @NonNull ConnectionLifecycleCallback connectionLifecycleCallback, @NonNull AdvertisingOptions advertisingOptions);

    @NonNull
    Task<Void> startDiscovery(@NonNull String str, @NonNull EndpointDiscoveryCallback endpointDiscoveryCallback, @NonNull DiscoveryOptions discoveryOptions);

    void stopAdvertising();

    void stopAllEndpoints();

    void stopDiscovery();
}
