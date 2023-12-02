package com.google.android.gms.nearby.messages;

import android.app.PendingIntent;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface Messages {
    @NonNull
    @Deprecated
    PendingResult<Status> getPermissionStatus(@NonNull GoogleApiClient googleApiClient);

    void handleIntent(@NonNull Intent intent, @NonNull MessageListener messageListener);

    @NonNull
    PendingResult<Status> publish(@NonNull GoogleApiClient googleApiClient, @NonNull Message message);

    @NonNull
    PendingResult<Status> publish(@NonNull GoogleApiClient googleApiClient, @NonNull Message message, @NonNull PublishOptions publishOptions);

    @NonNull
    PendingResult<Status> registerStatusCallback(@NonNull GoogleApiClient googleApiClient, @NonNull StatusCallback statusCallback);

    @NonNull
    PendingResult<Status> subscribe(@NonNull GoogleApiClient googleApiClient, @NonNull PendingIntent pendingIntent);

    @NonNull
    PendingResult<Status> subscribe(@NonNull GoogleApiClient googleApiClient, @NonNull PendingIntent pendingIntent, @NonNull SubscribeOptions subscribeOptions);

    @NonNull
    PendingResult<Status> subscribe(@NonNull GoogleApiClient googleApiClient, @NonNull MessageListener messageListener);

    @NonNull
    PendingResult<Status> subscribe(@NonNull GoogleApiClient googleApiClient, @NonNull MessageListener messageListener, @NonNull SubscribeOptions subscribeOptions);

    @NonNull
    PendingResult<Status> unpublish(@NonNull GoogleApiClient googleApiClient, @NonNull Message message);

    @NonNull
    PendingResult<Status> unregisterStatusCallback(@NonNull GoogleApiClient googleApiClient, @NonNull StatusCallback statusCallback);

    @NonNull
    PendingResult<Status> unsubscribe(@NonNull GoogleApiClient googleApiClient, @NonNull PendingIntent pendingIntent);

    @NonNull
    PendingResult<Status> unsubscribe(@NonNull GoogleApiClient googleApiClient, @NonNull MessageListener messageListener);
}
