package com.google.android.gms.nearby.messages;

import android.app.PendingIntent;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface MessagesClient extends HasApiKey<MessagesOptions> {
    void handleIntent(@NonNull Intent intent, @NonNull MessageListener messageListener);

    @NonNull
    Task<Void> publish(@NonNull Message message);

    @NonNull
    Task<Void> publish(@NonNull Message message, @NonNull PublishOptions publishOptions);

    @NonNull
    Task<Void> registerStatusCallback(@NonNull StatusCallback statusCallback);

    @NonNull
    Task<Void> subscribe(@NonNull PendingIntent pendingIntent);

    @NonNull
    Task<Void> subscribe(@NonNull PendingIntent pendingIntent, @NonNull SubscribeOptions subscribeOptions);

    @NonNull
    Task<Void> subscribe(@NonNull MessageListener messageListener);

    @NonNull
    Task<Void> subscribe(@NonNull MessageListener messageListener, @NonNull SubscribeOptions subscribeOptions);

    @NonNull
    Task<Void> unpublish(@NonNull Message message);

    @NonNull
    Task<Void> unregisterStatusCallback(@NonNull StatusCallback statusCallback);

    @NonNull
    Task<Void> unsubscribe(@NonNull PendingIntent pendingIntent);

    @NonNull
    Task<Void> unsubscribe(@NonNull MessageListener messageListener);
}
