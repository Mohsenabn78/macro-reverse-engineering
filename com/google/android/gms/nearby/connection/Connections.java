package com.google.android.gms.nearby.connection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface Connections {
    @Deprecated
    public static final long DURATION_INDEFINITE = 0;
    public static final int MAX_BYTES_DATA_SIZE = 32768;
    @Deprecated
    public static final int MAX_RELIABLE_MESSAGE_LEN = 4096;
    @Deprecated
    public static final int MAX_UNRELIABLE_MESSAGE_LEN = 1168;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface ConnectionResponseCallback {
        void onConnectionResponse(@NonNull String str, @NonNull Status status, @NonNull byte[] bArr);
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface MessageListener {
        @Deprecated
        void onDisconnected(@NonNull String str);

        @Deprecated
        void onMessageReceived(@NonNull String str, @NonNull byte[] bArr, boolean z3);
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public interface StartAdvertisingResult extends Result {
        @NonNull
        String getLocalEndpointName();
    }

    @NonNull
    PendingResult<Status> acceptConnection(@NonNull GoogleApiClient googleApiClient, @NonNull String str, @NonNull PayloadCallback payloadCallback);

    @NonNull
    @Deprecated
    PendingResult<Status> acceptConnectionRequest(@NonNull GoogleApiClient googleApiClient, @NonNull String str, @NonNull byte[] bArr, @NonNull MessageListener messageListener);

    @NonNull
    PendingResult<Status> cancelPayload(@NonNull GoogleApiClient googleApiClient, long j4);

    void disconnectFromEndpoint(@NonNull GoogleApiClient googleApiClient, @NonNull String str);

    @NonNull
    PendingResult<Status> rejectConnection(@NonNull GoogleApiClient googleApiClient, @NonNull String str);

    @NonNull
    @Deprecated
    PendingResult<Status> rejectConnectionRequest(@NonNull GoogleApiClient googleApiClient, @NonNull String str);

    @NonNull
    PendingResult<Status> requestConnection(@NonNull GoogleApiClient googleApiClient, @Nullable String str, @NonNull String str2, @NonNull ConnectionLifecycleCallback connectionLifecycleCallback);

    @NonNull
    @Deprecated
    PendingResult<Status> sendConnectionRequest(@NonNull GoogleApiClient googleApiClient, @NonNull String str, @NonNull String str2, @NonNull byte[] bArr, @NonNull ConnectionResponseCallback connectionResponseCallback, @NonNull MessageListener messageListener);

    @NonNull
    PendingResult<Status> sendPayload(@NonNull GoogleApiClient googleApiClient, @NonNull String str, @NonNull Payload payload);

    @NonNull
    PendingResult<Status> sendPayload(@NonNull GoogleApiClient googleApiClient, @NonNull List<String> list, @NonNull Payload payload);

    @Deprecated
    void sendReliableMessage(@NonNull GoogleApiClient googleApiClient, @NonNull String str, @NonNull byte[] bArr);

    @Deprecated
    void sendReliableMessage(@NonNull GoogleApiClient googleApiClient, @NonNull List<String> list, @NonNull byte[] bArr);

    @Deprecated
    void sendUnreliableMessage(@NonNull GoogleApiClient googleApiClient, @NonNull String str, @NonNull byte[] bArr);

    @Deprecated
    void sendUnreliableMessage(@NonNull GoogleApiClient googleApiClient, @NonNull List<String> list, @NonNull byte[] bArr);

    @NonNull
    @Deprecated
    PendingResult<StartAdvertisingResult> startAdvertising(@NonNull GoogleApiClient googleApiClient, @NonNull String str, @NonNull AppMetadata appMetadata, long j4, @NonNull ConnectionRequestListener connectionRequestListener);

    @NonNull
    PendingResult<StartAdvertisingResult> startAdvertising(@NonNull GoogleApiClient googleApiClient, @NonNull String str, @NonNull String str2, @NonNull ConnectionLifecycleCallback connectionLifecycleCallback, @NonNull AdvertisingOptions advertisingOptions);

    @NonNull
    @Deprecated
    PendingResult<Status> startDiscovery(@NonNull GoogleApiClient googleApiClient, @NonNull String str, long j4, @NonNull EndpointDiscoveryListener endpointDiscoveryListener);

    @NonNull
    PendingResult<Status> startDiscovery(@NonNull GoogleApiClient googleApiClient, @NonNull String str, @NonNull EndpointDiscoveryCallback endpointDiscoveryCallback, @NonNull DiscoveryOptions discoveryOptions);

    void stopAdvertising(@NonNull GoogleApiClient googleApiClient);

    void stopAllEndpoints(@NonNull GoogleApiClient googleApiClient);

    void stopDiscovery(@NonNull GoogleApiClient googleApiClient);

    @Deprecated
    void stopDiscovery(@NonNull GoogleApiClient googleApiClient, @NonNull String str);

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public static abstract class ConnectionRequestListener {
        public void onConnectionRequest(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public static abstract class EndpointDiscoveryListener {
        public abstract void onEndpointLost(@NonNull String str);

        public void onEndpointFound(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        }
    }
}
