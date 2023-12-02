package com.google.android.gms.wearable;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface MessageApi {
    @NonNull
    public static final String ACTION_MESSAGE_RECEIVED = "com.google.android.gms.wearable.MESSAGE_RECEIVED";
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;
    public static final int UNKNOWN_REQUEST_ID = -1;

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface FilterType {
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface MessageListener {
        void onMessageReceived(@NonNull MessageEvent messageEvent);
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface SendMessageResult extends Result {
        int getRequestId();
    }

    @NonNull
    PendingResult<Status> addListener(@NonNull GoogleApiClient googleApiClient, @NonNull MessageListener messageListener);

    @NonNull
    PendingResult<Status> addListener(@NonNull GoogleApiClient googleApiClient, @NonNull MessageListener messageListener, @NonNull Uri uri, int i4);

    @NonNull
    PendingResult<Status> removeListener(@NonNull GoogleApiClient googleApiClient, @NonNull MessageListener messageListener);

    @NonNull
    PendingResult<SendMessageResult> sendMessage(@NonNull GoogleApiClient googleApiClient, @NonNull String str, @NonNull String str2, @NonNull byte[] bArr);
}
