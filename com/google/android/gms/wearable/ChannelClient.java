package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Wearable;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class ChannelClient extends GoogleApi<Wearable.WearableOptions> {
    @NonNull
    public static final String ACTION_CHANNEL_EVENT = "com.google.android.gms.wearable.CHANNEL_EVENT";

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    /* loaded from: classes4.dex */
    public interface Channel extends Parcelable {
        @NonNull
        String getNodeId();

        @NonNull
        String getPath();
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface CloseReason {
    }

    public ChannelClient(@NonNull Activity activity, @NonNull GoogleApi.Settings settings) {
        super(activity, Wearable.API, Wearable.WearableOptions.f22646b, settings);
    }

    @NonNull
    public abstract Task<Void> close(@NonNull Channel channel);

    @NonNull
    public abstract Task<Void> close(@NonNull Channel channel, int i4);

    @NonNull
    public abstract Task<InputStream> getInputStream(@NonNull Channel channel);

    @NonNull
    public abstract Task<OutputStream> getOutputStream(@NonNull Channel channel);

    @NonNull
    public abstract Task<Channel> openChannel(@NonNull String str, @NonNull String str2);

    @NonNull
    public abstract Task<Void> receiveFile(@NonNull Channel channel, @NonNull Uri uri, boolean z3);

    @NonNull
    public abstract Task<Void> registerChannelCallback(@NonNull Channel channel, @NonNull ChannelCallback channelCallback);

    @NonNull
    public abstract Task<Void> registerChannelCallback(@NonNull ChannelCallback channelCallback);

    @NonNull
    public abstract Task<Void> sendFile(@NonNull Channel channel, @NonNull Uri uri);

    @NonNull
    public abstract Task<Void> sendFile(@NonNull Channel channel, @NonNull Uri uri, long j4, long j5);

    @NonNull
    public abstract Task<Boolean> unregisterChannelCallback(@NonNull Channel channel, @NonNull ChannelCallback channelCallback);

    @NonNull
    public abstract Task<Boolean> unregisterChannelCallback(@NonNull ChannelCallback channelCallback);

    public ChannelClient(@NonNull Context context, @NonNull GoogleApi.Settings settings) {
        super(context, Wearable.API, Wearable.WearableOptions.f22646b, settings);
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    /* loaded from: classes4.dex */
    public static abstract class ChannelCallback {
        public static final int CLOSE_REASON_DISCONNECTED = 1;
        public static final int CLOSE_REASON_LOCAL_CLOSE = 3;
        public static final int CLOSE_REASON_NORMAL = 0;
        public static final int CLOSE_REASON_REMOTE_CLOSE = 2;

        public void onChannelOpened(@NonNull Channel channel) {
        }

        public void onChannelClosed(@NonNull Channel channel, int i4, int i5) {
        }

        public void onInputClosed(@NonNull Channel channel, int i4, int i5) {
        }

        public void onOutputClosed(@NonNull Channel channel, int i4, int i5) {
        }
    }
}
