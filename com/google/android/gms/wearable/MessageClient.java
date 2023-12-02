package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Wearable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class MessageClient extends GoogleApi<Wearable.WearableOptions> {
    @NonNull
    public static final String ACTION_MESSAGE_RECEIVED = "com.google.android.gms.wearable.MESSAGE_RECEIVED";
    @NonNull
    public static final String ACTION_REQUEST_RECEIVED = "com.google.android.gms.wearable.REQUEST_RECEIVED";
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface FilterType {
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    /* loaded from: classes4.dex */
    public interface OnMessageReceivedListener extends MessageApi.MessageListener {
        @Override // com.google.android.gms.wearable.MessageApi.MessageListener
        void onMessageReceived(@NonNull MessageEvent messageEvent);
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @ShowFirstParty
    /* loaded from: classes4.dex */
    public interface RpcService {
        @Nullable
        Task<byte[]> onRequest(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr);
    }

    public MessageClient(@NonNull Activity activity, @NonNull GoogleApi.Settings settings) {
        super(activity, Wearable.API, Wearable.WearableOptions.f22646b, settings);
    }

    @NonNull
    public abstract Task<Void> addListener(@NonNull OnMessageReceivedListener onMessageReceivedListener);

    @NonNull
    public abstract Task<Void> addListener(@NonNull OnMessageReceivedListener onMessageReceivedListener, @NonNull Uri uri, int i4);

    @NonNull
    public abstract Task<Void> addRpcService(@NonNull RpcService rpcService, @NonNull String str);

    @NonNull
    public abstract Task<Void> addRpcService(@NonNull RpcService rpcService, @NonNull String str, @NonNull String str2);

    @NonNull
    public abstract Task<Boolean> removeListener(@NonNull OnMessageReceivedListener onMessageReceivedListener);

    @NonNull
    public abstract Task<Boolean> removeRpcService(@NonNull RpcService rpcService);

    @NonNull
    public abstract Task<Integer> sendMessage(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr);

    @NonNull
    public abstract Task<Integer> sendMessage(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr, @NonNull MessageOptions messageOptions);

    @NonNull
    public abstract Task<byte[]> sendRequest(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr);

    public MessageClient(@NonNull Context context, @NonNull GoogleApi.Settings settings) {
        super(context, Wearable.API, Wearable.WearableOptions.f22646b, settings);
    }
}
