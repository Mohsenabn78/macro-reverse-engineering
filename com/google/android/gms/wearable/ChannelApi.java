package com.google.android.gms.wearable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface ChannelApi {
    @NonNull
    public static final String ACTION_CHANNEL_EVENT = "com.google.android.gms.wearable.CHANNEL_EVENT";

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface ChannelListener {
        public static final int CLOSE_REASON_CONNECTION_TIMEOUT = 4;
        public static final int CLOSE_REASON_DISCONNECTED = 1;
        public static final int CLOSE_REASON_LOCAL_CLOSE = 3;
        public static final int CLOSE_REASON_NORMAL = 0;
        public static final int CLOSE_REASON_REMOTE_CLOSE = 2;

        void onChannelClosed(@NonNull Channel channel, int i4, int i5);

        void onChannelOpened(@NonNull Channel channel);

        void onInputClosed(@NonNull Channel channel, int i4, int i5);

        void onOutputClosed(@NonNull Channel channel, int i4, int i5);
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface CloseReason {
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface OpenChannelResult extends Result {
        @Nullable
        Channel getChannel();
    }

    @NonNull
    PendingResult<Status> addListener(@NonNull GoogleApiClient googleApiClient, @NonNull ChannelListener channelListener);

    @NonNull
    PendingResult<OpenChannelResult> openChannel(@NonNull GoogleApiClient googleApiClient, @NonNull String str, @NonNull String str2);

    @NonNull
    PendingResult<Status> removeListener(@NonNull GoogleApiClient googleApiClient, @NonNull ChannelListener channelListener);
}
